package model.member;

public class Student extends member_Record {
    public Student(int member_id, String type, String date_of_membership, int no_books_issued, String name, String address, String phone_no) {
        super(member_id, type, date_of_membership, no_books_issued, name, address, phone_no);
    }
}