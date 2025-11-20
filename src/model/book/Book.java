package model.book;

import model.person.Author;

import java.util.Date;
import java.util.Objects;

public class Book implements Borrowable{
    private int book_ID;
    private Author author;
    private String name;
    private double price;
    private boolean status;
    private String edition;
    private Date date_of_purchase;

    public Book(int book_ID, Author author, String name, double price, boolean status, String edition, Date date_of_purchase) {
        this.book_ID = book_ID;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.date_of_purchase = date_of_purchase;
    }

    public int getBook_ID() {
        return book_ID;
    }

    public Author getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean getStatus() {
        return status;
    }

    public String getEdition() {
        return edition;
    }

    public Date getDate_of_purchase() {
        return date_of_purchase;
    }

    public void setBook_ID(int book_ID) {
        this.book_ID = book_ID;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setDate_of_purchase(Date date_of_purchase) {
        this.date_of_purchase = date_of_purchase;
    }


    @Override
    public void updateBorrowStatus() {
        this.status =  !status;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return book_ID == book.book_ID && Double.compare(price, book.price) == 0 && Objects.equals(author, book.author)
                && Objects.equals(name, book.name) && Objects.equals(status, book.status) &&
                Objects.equals(edition, book.edition) && Objects.equals(date_of_purchase, book.date_of_purchase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book_ID, author, name, price, status, edition, date_of_purchase);
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_ID=" + book_ID +
                ", author=" + author +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", edition='" + edition + '\'' +
                ", date_of_purchase=" + date_of_purchase +
                '}';
    }
}
