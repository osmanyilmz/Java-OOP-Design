package model.member;

import model.person.Reader;

import java.util.Objects;

public class member_Record {
    private int member_id;
    private String type;
    private String date_of_membership;
    private int no_books_issued = 0;
    private final int max_book_limit = 5;
    private String name;
    private String address;
    private String phone_no;

    public member_Record(int member_id, String type, String date_of_membership, int no_books_issued, String name, String address, String phone_no) {
        this.member_id = member_id;
        this.type = type;
        this.date_of_membership = date_of_membership;
        this.no_books_issued = no_books_issued;
        this.name = name;
        this.address = address;
        this.phone_no = phone_no;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        member_Record that = (member_Record) o;
        return member_id == that.member_id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(member_id);
    }

    @Override
    public String toString() {
        return "member_Record{" +
                "member_id=" + member_id +
                ", type='" + type + '\'' +
                ", date_of_membership='" + date_of_membership + '\'' +
                ", no_books_issued=" + no_books_issued +
                ", max_book_limit=" + max_book_limit +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone_no='" + phone_no + '\'' +
                '}';
    }



    public Reader getMember() { return null; }
    public void inc_book_issued() {}
    public void dec_book_issued() {}
    public void pay_bill() {}
}
