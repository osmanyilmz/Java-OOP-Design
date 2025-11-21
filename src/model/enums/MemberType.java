package model.enums;

public enum MemberType {
    STUDENT("stu"),
    FACULTY("fac");

    private final String type;

    MemberType(String type) {
        this.type = type;
    }
}
