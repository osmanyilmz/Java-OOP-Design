package model;

import model.person.Person;

public class Librarian extends Person {
    private Library library;

    public Librarian(String name, String id, Library library) {
        super(name, id);
    }

}
