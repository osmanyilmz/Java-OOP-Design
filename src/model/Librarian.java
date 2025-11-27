package model;

import model.enums.BookCategory;

public class Librarian extends Person {
    private Library library;

    public Librarian(String name, String id, Library library) {
        super(name, id);
        this.library = library;
    }

    public void addBook(Book book){
        library.getBookMap().put(book.getBook_ID(), book);
        library.getBookIds().add(book.getBook_ID());
        System.out.println(getName() + "adlı kütüphaneci kitap ekledi: " + book.getName());
    }

    public void removeBook(String id){
        Book book = library.findBookById(id);
        if(book != null) {
            library.getBookMap().remove(id);
            library.getBookIds().remove(id);
            System.out.println(getName() + "adlı kütüphaneci kitabı kaldırdı: " + book.getName());
        } else {
            System.out.println("Kitap bulunamadı.");
        }
    }

    public void updateBook(String id, String newTitle, String newAuthor, BookCategory newCategory) {
        Book book = library.findBookById(id);
        if(book != null) {
            book.setName(newTitle);
            book.setAuthor(newAuthor);
            book.setCategory(newCategory);
            System.out.println("Kütüphaneci kitabı güncelledi: " + newTitle);
        } else {
            System.out.println("Kitap bulunamadı.");
        }
    }
}
