package model.book;

import model.person.Author;

import java.util.Date;

public class Book {
    private int book_ID;
    private Author author;
    private String name;
    private double price;
    private String status;
    private String edition;
    private Date date_of_purchase;

    public Book() {}

    public void get_title() {}
    public void get_author() {}
    public void change_owner() {}
    public void get_owner() {}
    public void display() {}
    public void update_status() {}
}
