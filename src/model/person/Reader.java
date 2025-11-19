package model.person;

import model.book.Book;

import java.util.List;

public class Reader extends Person {
    private List<Book> books;

    public Reader() {}

    public void purchase_book() {}
    public void borrow_book() {}
    public void return_book() {}
    @Override
    public void whoyouare() {}
}