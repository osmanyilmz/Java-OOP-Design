package model.book;

import model.person.Author;

import java.util.Date;

public class Journals extends Book {
    public Journals(int book_ID, Author author, String name, double price, boolean status, String edition, Date date_of_purchase) {
        super(book_ID, author, name, price, status, edition, date_of_purchase);
    }

    @Override
    public String toString() {

        return "Journal{" +
                "JournalId=" + getBook_ID() +
                ", author='" + getAuthor()
                ;

    }
}