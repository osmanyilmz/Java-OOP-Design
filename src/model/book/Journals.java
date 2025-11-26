package model.book;

import model.enums.BookCategory;

public class Journals extends Book {


    public Journals(String book_ID, String author, String name, BookCategory category) {
        super(book_ID, author, name, category);
    }

    @Override
    public String toString() {

        return "Journal{" +
                "JournalId=" + getBook_ID() +
                ", author='" + getAuthor()
                ;

    }
}