package model.book;

import model.person.Author;

import java.util.Date;

public class Magazines extends Book {


    public Magazines(String book_ID, String author, String name, BookCategory category) {
        super(book_ID, author, name, category);
    }

    @Override
    public String toString() {

        return "Magazine{" +
                "MagazineId=" + getBook_ID() +
                ", author='" + getAuthor() + '\'' +
                ", title='" + getName() + '\'' ;
    }
}
