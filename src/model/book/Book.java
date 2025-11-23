package model.book;

import model.person.Author;

public class Book {
    private int book_ID;
    private Author author;
    private String name;
    //private double price;
    private String status;
    //private String edition;
    //private Date date_of_purchase;
    private BookCategory category;

    public Book(int book_ID, Author author, String name, BookCategory category) {
        this.book_ID = book_ID;
        this.author = author;
        this.name = name;
        this.status = "AVAILABLE";
        this.category = category;
    }

    public int getBook_ID() {
        return book_ID;
    }

    public Author getAuthor() {
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

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }
}
