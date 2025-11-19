package model;

import model.book.Book;
import model.person.Reader;

public class Librarian {
    private String name;
    private String password;

    public Librarian() {}

    public void searchBook(String title) {}
    public void verifyMember(Reader r) {}
    public void issueBook(Book b, Reader r) {}
    public void calculateFine(Reader r) {}
    public void createBill(Reader r, Book b) {}
    public void returnBook(Book b, Reader r) {}
}
