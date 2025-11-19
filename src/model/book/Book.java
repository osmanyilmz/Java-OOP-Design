package model.book;

import model.person.Author;
import model.person.Reader;

import java.util.Date;

public class Book {
    protected int book_ID;
    protected Author author;
    protected String name;
    protected double price;
    protected String status;
    protected String edition;
    protected Date date_of_purchase;
    protected String title;
    protected Reader owner;

    public Book() {}

    public void get_title() {}
    public void get_author() {}
    public void change_owner() {}
    public void get_owner() {}
    public void display() {}
    public void update_status() {}
}
