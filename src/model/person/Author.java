package model.person;

import model.book.Book;

import java.util.List;

public class Author extends Person {
    protected List<Book> books;

    public Author() {}

    public void new_book() {}
    public void show_book() {}
    @Override
    public void whoyouare() {}
}