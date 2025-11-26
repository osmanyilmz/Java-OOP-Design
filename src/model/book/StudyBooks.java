package model.book;

import model.enums.BookCategory;

public class StudyBooks extends Book {

    public StudyBooks(String book_ID, String author, String name, BookCategory category) {
        super(book_ID, author, name, category);
    }
}
