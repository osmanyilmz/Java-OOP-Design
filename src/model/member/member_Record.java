package model.member;

import model.person.Reader;

public class member_Record {
    private int member_id;
    private String type;
    private String date_of_membership;
    private int no_books_issued;
    private int max_book_limit;
    private String name;
    private String address;
    private String phone_no;

    public member_Record() {}

    public Reader getMember() { return null; }
    public void inc_book_issued() {}
    public void dec_book_issued() {}
    public void pay_bill() {}
}
