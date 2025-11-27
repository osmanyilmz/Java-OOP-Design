import model.Library;
import model.Reader;
import model.Book;
import model.enums.BookCategory;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.loadDefaultBooks();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kütüphaneye Hoşgeldiniz");

        while (true) {
            System.out.println("\nMenü:");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Okuyucu Ekle");
            System.out.println("3. ID'ye Göre Kitap Arama");
            System.out.println("4. Başlığa Göre Kitap Arama");
            System.out.println("5. Kitapları Kategoriye Göre Listele");
            System.out.println("6. Kitap Ödünç Al");
            System.out.println("7. Kitabı İade Et");
            System.out.println("8. Yazar Adına Göre Kitap Arama");
            System.out.println("9. Kitap Bilgilerini Güncelle");
            System.out.println("10. Kitap Sil");
            System.out.println("11. Tüm Kitapları Listele");
            System.out.println("12. Çıkış");
            System.out.println("Bir Seçenek Seçin: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Kitap ID'sini Giriniz: ");
                    String id = scanner.nextLine();
                    System.out.println("Kitap başlığı Giriniz: ");
                    String title = scanner.nextLine();
                    System.out.println("Kitap Yazarı Giriniz: ");
                    String author = scanner.nextLine();
                    System.out.println("Bir Kategori Seçin:  FICTION, PSYCHOLOGY, HISTORY, POETRY, PHILOSOPHY, ART");
                    String categoryInput = scanner.nextLine().toUpperCase();

                    try {
                        BookCategory category = BookCategory.valueOf(categoryInput);
                        library.addBook(new Book(id, title, author, category));
                        System.out.println("Kitap Başarıyla Eklendi!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Geçersiz Kategori. Lütfen Tekrar Deneyin!");
                    }
                    break;

                case 2:
                    System.out.println("Okuyucu ID'sini Giriniz: ");
                    String readerId2 = scanner.nextLine();
                    System.out.println("Okuyucu Adını Giriniz: ");
                    String readerName = scanner.nextLine();

                    Reader newReader = new Reader(readerName, readerId2);
                    library.addReader(newReader);
                    break;

                case 3:
                    System.out.println("Aramak İçin Kitap ID'sini Giriniz: ");
                    String searchId = scanner.nextLine();
                    Book foundBook = library.findBookById(searchId);
                    if(foundBook != null) {
                        System.out.println("Kitap bulundu: " + foundBook.getDetails());
                    } else {
                        System.out.println("Kitap Bulunamadı!");
                    }
                    break;

                case 4:
                    System.out.println("Aramak İstediğiniz Kitap Başlığını Giriniz: ");
                    String searchTitle = scanner.nextLine();
                    library.findBooksByTitle(searchTitle).forEach(book -> System.out.println(book.getDetails()));
                    break;

                case 5:
                    System.out.println("Listelenecek Bir Kategori Seçin: FICTION, PSYCHOLOGY, HISTORY, POETRY, PHILOSOPHY, ART");
                    String listCategoryInput = scanner.nextLine().toUpperCase();

                    try {
                        BookCategory listCategory = BookCategory.valueOf(listCategoryInput);
                        library.listBooksByCategory(listCategory).forEach(book -> System.out.println(book.getDetails()));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Geçersiz Kategori. Lütfen Tekrar Deneyin!");
                    }
                    break;

                case 6:
                    System.out.println("Okuyucu ID'nizi Giriniz: ");
                    String readerId6 = scanner.nextLine();

                    Reader readerForBorrow = library.findReaderById(readerId6);
                    if (readerForBorrow == null) {
                        System.out.println("Okuyucu bulunamadı!");
                        break;
                    }

                    System.out.println("Ödünç Alınacak Kitap ID'sini Giriniz: ");
                    String borrowBookId = scanner.nextLine();

                    Book bookToBorrow = library.findBookById(borrowBookId);
                    if (bookToBorrow == null) {
                        System.out.println("Kitap bulunamadı!");
                        break;
                    }

                    System.out.println("Ödünç Alma Tarihini Giriniz (YYYY-MM-DD): ");
                    String borrowDateInput = scanner.nextLine();

                    LocalDate borrowDate;
                    try {
                        borrowDate = LocalDate.parse(borrowDateInput);
                    } catch (Exception e) {
                        System.out.println("Tarih formatı yanlış!");
                        break;
                    }
                    library.borrowBook(readerForBorrow, bookToBorrow, borrowDate);
                    break;

                case 7:
                    System.out.println("Okuyucu ID'nizi Giriniz: ");
                    String returnReaderId = scanner.nextLine();

                    Reader readerForReturn = library.findReaderById(returnReaderId);
                    if (readerForReturn == null) {
                        System.out.println("Okuyucu bulunamadı!");
                        break;
                    }

                    System.out.println("İade Etmek İçin Kitap ID'sini Giriniz: ");
                    String returnBookId = scanner.nextLine();

                    Book bookToReturn = library.findBookById(returnBookId);
                    if (bookToReturn == null) {
                        System.out.println("Kitap bulunamadı!");
                        break;
                    }

                    System.out.println("İade Tarihini Giriniz (YYYY-MM-DD): ");
                    String returnDateInput = scanner.nextLine();

                    LocalDate returnDate;
                    try {
                        returnDate = LocalDate.parse(returnDateInput);
                    } catch (Exception e) {
                        System.out.println("Tarih formatı hatalı! Örnek: 2025-11-30");
                        break;
                    }

                    System.out.println("Hasarlı Sayfa Sayısını Giriniz: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Geçersiz giriş. Lütfen pozitif bir değer giriniz.");
                        scanner.next();
                    }
                    int damagedPages = scanner.nextInt();
                    scanner.nextLine();

                    if (damagedPages < 0) {
                        System.out.println("Hasarlı sayfa sayısı negatif olamaz.");
                        break;
                    }

                    library.returnBook(readerForReturn, bookToReturn, returnDate, damagedPages);
                    break;

                case 8:
                    System.out.println("Yazar Adını Giriniz: ");
                    String searchAuthor = scanner.nextLine();
                    library.findBooksByAuthor(searchAuthor).forEach(book -> System.out.println(book.getDetails()));
                    break;

                case 9:
                    System.out.println("Güncellenecek Kitap ID'sini Giriniz: ");
                    String updateId = scanner.nextLine();
                    System.out.println("Yeni Başlık Giriniz: ");
                    String newTitle = scanner.nextLine();
                    System.out.println("Yeni Yazar Giriniz: ");
                    String newAuthor = scanner.nextLine();
                    System.out.println("Yeni Kategori Giriniz: FICTION, PSYCHOLOGY, HISTORY, POETRY, PHILOSOPHY, ART");
                    String newCategoryInput  = scanner.nextLine().toUpperCase();

                    try{
                        BookCategory newCategory = BookCategory.valueOf(newCategoryInput);
                        library.updateBookInfo(updateId, newTitle, newAuthor,newCategory);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Geçersiz Kategori. Lütfen Tekrar Deneyin!");
                    }
                    break;

                case 10:
                    System.out.println("Silmek İstediğiniz Kitap ID'sini Giriniz:");
                    String removeId = scanner.nextLine();
                    library.removeBook(removeId);
                    break;

                case 11:
                    System.out.println("Kütüphanedeki Tüm Kitaplar:");
                    if (library.getBookMap().isEmpty()) {
                        System.out.println("Kütüphanede kitap bulunmamaktadır.");
                    } else {
                        library.getBookMap().values().forEach(book -> System.out.println(book.getDetails()));
                    }
                    break;

                case 12:
                    System.out.println("Sistemden Çıkılıyor!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Geçersiz Seçenek. Lütfen Tekrar Deneyin!");

            }
        }
    }
}