package model.book;

import model.person.Author;

public class Journals extends Book {

    public Journals(int book_ID, Author author, String name, BookCategory category) {
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