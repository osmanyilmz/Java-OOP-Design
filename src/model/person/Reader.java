package model.person;


import model.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person {

    private List<Book> borrowedBooks;


    public Reader(String name, String id) {
        super(name, id);
        this.borrowedBooks = new ArrayList<>();
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}