package model;

import model.enums.BookCategory;

import java.time.LocalDate;
import java.util.*;

public class Library {

    private List<Book> books;
    private List<Reader> readers;
    private List<Borrowable> borrowRecords;
    private Set<String> readerIds;
    private Set<String> bookIds;
    private Map<String, List<Borrowable>> borrowRecordMap;
    private Map<String, Book> bookMap;
    private Librarian librarian;


    public Library() {
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
        this.borrowRecords = new ArrayList<>();
        this.readerIds = new HashSet<>();
        this.bookIds = new HashSet<>();
        this.borrowRecordMap = new HashMap<>();
        this.bookMap = new HashMap<>();
        this.librarian = new Librarian("Cansu", "1", this);

        addReader(new Reader("Osman Yılmaz", "R1"));
        addReader(new Reader("Mehmet Yılmaz", "R2"));
        addReader(new Reader("Ayşe Yılmaz", "R3"));
    }

    public void loadDefaultBooks() {
        addBook(new Book("1", "Suç ve Ceza", "Dostoyevski", BookCategory.FICTION));
        addBook(new Book("2", "1984", "George Orwell", BookCategory.FICTION));
        addBook(new Book("3", "Bilinçaltının Gücü", "Joseph Murphy", BookCategory.PSYCHOLOGY));
        addBook(new Book("4", "Nutuk", "Mustafa Kemal Atatürk", BookCategory.HISTORY));
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void addReader(Reader reader) {
        if(readerIds.contains(reader.getId())) {
            System.out.println("Kimliği " + reader.getId() + " olan okuyucu zaten mevcut.");
        } else {
            readers.add(reader);
                readerIds.add(reader.getId());
                System.out.println("Okuyucu başarıyla eklendi.");
        }
    }

    public Map<String ,Book> getBookMap(){
        return bookMap;
    }

    public Set<String> getBookIds() {
        return bookIds;
    }

    public void addBook(Book book) {
        librarian.addBook(book);
    }

    public Book findBookById(String id) {
        return bookMap.get(id);
    }

    public List<Book> findBooksByTitle(String title) {
        List<Book> filteredBooks = new ArrayList<>();
        for(Book book: books) {
            if(book.getName().equalsIgnoreCase(title)){
                filteredBooks.add(book);
            }
        }
        return  filteredBooks;
    }

    public Reader findReaderById(String id) {
        for (Reader r : readers) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> filteredBooks = new ArrayList<>();
        for(Book book: books) {
            if(book.getAuthor().equalsIgnoreCase(author)){
                filteredBooks.add(book);
            }
        }
        return  filteredBooks;
    }

    public void updateBookInfo(String bookId, String newTitle, String newAuthor, BookCategory newCategory) {
        librarian.updateBook(bookId, newTitle, newAuthor, newCategory);
    }

    public void removeBook(String bookId) {
        librarian.removeBook(bookId);
    }

    public List<Book> listBooksByCategory(BookCategory category) {
        List<Book> filteredBooks = new ArrayList<>();
        for(Book book: books) {
            if (book.getCategory() == category) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    public void borrowBook(Reader reader, Book book, LocalDate borrowDate) {
        if (book.getStatus().equals("AVAILABLE")) {
            reader.borrowBook(book);
            Borrowable record = new Borrowable(reader.getId(), book.getBook_ID(), borrowDate);
            borrowRecords.add(record);
            borrowRecordMap.computeIfAbsent(reader.getId(), k -> new ArrayList<>()).add(record);
            book.updateStatus("BORROWED");
            bookMap.put(book.getBook_ID(), book);
            System.out.println("Kitap başarıyla ödünç alındı.");
        } else {
            System.out.println("Bu kitap mevcut değil.");
        }
    }

    public void returnBook(Reader reader, Book book, LocalDate returnDate, int damagedPages) {
        if(!reader.getBorrowedBooks().contains(book)) {
            System.out.println(reader.getName() + "adlı okuyucu tarafından bu kitap ödünç alınmadı.");
            return;
        }
        reader.returnBook(book);

        List<Borrowable> records = borrowRecordMap.get(reader.getId());
        if(records == null) {
            System.out.println(reader.getName() + "adlı kullanıcıya ait ödünç kitap kaydı bulunamadı.");
            return;
        }

        Borrowable record = records.stream().filter(r -> r.getBookId().equals(book.getBook_ID())).findFirst().orElse(null);

        if(record != null) {
            record.setReturnDate(returnDate);
        }

        int allowedDays = 30;
        Bill bill = new Bill(10.0, record.getBorrowDate());
        double totalCharge = bill.calculateTotalCharge(returnDate, allowedDays, damagedPages);

        if(totalCharge> 30) {
            System.out.println("Ek Ödeme Gerekli: " + (totalCharge - 10.0) + " TL");
        } else {
            System.out.println("Geri Ödeme Tutarı: " + (10.0 - totalCharge) + " TL");
        }

        System.out.println(bill.generateBill(returnDate, allowedDays, damagedPages));

        book.updateStatus("AVALIABLE");
        bookMap.put(book.getBook_ID(),book);
        System.out.println("Kitap İade Süreci Tamamlandı.");

        Notification notification = new Notification("Kitap İade Edildi: " + book.getName() + ", Toplam Ücret: " + totalCharge + " TL", LocalDate.now());
        System.out.println("Bildirim: " + notification.getMessage() + " | Tarih: " + notification.getNotificationDate());
    }
}