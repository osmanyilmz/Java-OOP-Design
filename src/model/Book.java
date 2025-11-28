package model;

import model.enums.BookCategory;

import java.util.Objects;

public class Book {
    private String bookId;
    private String name;
    private String author;
    private String status;
    private BookCategory category;
    private Reader owner;

    public Book(String bookId, String name, String author, BookCategory category) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.category = category;
        this.status = "AVAILABLE";
        this.owner = null;
    }

    public String getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public BookCategory getCategory() {
        return category;
    }

    public String getDetails() {
        return "ID: " + bookId + ", Title: " + name + ", Author: " + author + ", Status: " + status + ", Category: " + category;
    }

    public Reader getOwner() {
        return owner;
    }

    public void setOwner(Reader owner) {
        this.owner = owner;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

  @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != getClass())
            return false;
        Book book = (Book) obj;
        return Objects.equals(bookId, book.bookId);
    }

    @Override
    public int hashCode(){

        return Objects.hash(bookId);
    }

    @Override
    public String toString(){
        return "BookId :" + bookId;
    }
}