package model.book;

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
    }

    public void addReader(model.book.Reader reader) {
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

    public List<Book> findBooksByAuthor(String author) {
        List<Book> filteredBooks = new ArrayList<>();
        for(Book book: books) {
            if(book.getName().equalsIgnoreCase(author)){
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

    public List<Book> listBooksCategory(BookCategory category) {
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

        System.out.println(bill.generateInvoice(returnDate, allowedDays, damagedPages));

        book.updateStatus("AVALIABLE");
        bookMap.put(book.getBook_ID(),book);
        System.out.println("Kitap İade Süreci Tamamlandı.");


    }

}