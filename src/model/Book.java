package model;

import model.enums.BookCategory;

public class Book {
    private String book_ID;
    private String name;
    private String author;
    private String status;
    private BookCategory category;
    private Reader owner;

    public Book(String book_ID, String name, String author, BookCategory category) {
        this.book_ID = book_ID;
        this.name = name;
        this.author = author;
        this.category = category;
        this.status = "AVAILABLE";
        this.owner = null;
    }

    public String getBook_ID() {
        return book_ID;
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
        return "ID: " + book_ID + ", Title: " + name + ", Author: " + author + ", Status: " + status + ", Category: " + category;
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
}
