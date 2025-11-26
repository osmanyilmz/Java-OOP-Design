package model.book;

import model.person.Author;

public class Book {
    private String book_ID;
    private String name;
    private String author;
    private String status;
    private BookCategory category;

    public Book(String book_ID, String author, String name, BookCategory category) {
        this.book_ID = book_ID;
        this.author = author;
        this.name = name;
        this.status = "AVAILABLE";
        this.category = category;
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
