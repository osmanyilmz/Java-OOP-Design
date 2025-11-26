import model.book.Library;
import model.book.Reader;
import model.book.Book;
import model.book.BookCategory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
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
            System.out.println("11. Çıkış");
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
            }
        }
    }
}