package model.book;

import model.person.Author;

import java.util.Date;

public class Magazines extends Book {
    public Magazines(int book_ID, Author author, String name, double price, boolean status, String edition, Date date_of_purchase) {
        super(book_ID, author, name, price, status, edition, date_of_purchase);
    }

    @Override
    public String toString() {

        return "Magazine{" +
                "MagazineId=" + getBook_ID() +
                ", author='" + getAuthor() + '\'' +
                ", title='" + getName() + '\'' +
                ", price=" + getPrice();

    }
}
