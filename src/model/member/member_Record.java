package model.member;

public class member_Record {
    protected int member_id;
    protected String type;
    protected String date_of_membership;
    protected int no_books_issued;
    protected int max_book_limit;
    protected String name;
    protected String no;
    protected String address;

    public member_Record() {}

    public void get_member() {}
    public void inc_book_issued() {}
    public void dec_book_issued() {}
    public void pay_bill() {}
}
