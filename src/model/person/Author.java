package model.person;

import model.book.Book;

import java.util.List;

public class Author extends Person {
    private  List<Book> books;

    public Author(String name, String id) {
        super(name, id);
    }

    public void new_book() {}
    public void show_book() {}

}