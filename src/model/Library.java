package model;

import model.book.Book;
import model.book.Borrowable;

import java.io.Reader;
import java.util.*;

public class Library {

    private List<Book> books;
    private List<Reader> readers;
    private List<Borrowable> borrowRecords;
    private Set<String> readerIds;
    private Set<String> bookIds;
    private Map<String, List<Borrowable>> borrowRecordMap;
    private Map<String, Book> bookMap;
    private Librarian librarian;


    public Library() {
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
        this.borrowRecords = new ArrayList<>();
        this.readerIds = new HashSet<>();
        this.bookIds = new HashSet<>();
        this.borrowRecordMap = new HashMap<>();
        this.bookMap = new HashMap<>();
        this.librarian = new Librarian("Cansu", "1", this);
    }
}