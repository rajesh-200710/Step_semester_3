package main.java.week_6.class_problems;

public class PracticeProblem1 {
    public static void main(String[] args) {
        try {
            new LibraryMemberP1("LB1", 3);
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }

        StudentMemberP1 s = new StudentMemberP1("STU10", 3, "CSE");
        s.borrowBook();
        s.borrowBook();
        System.out.println(s.getBooksBorrowed());

        String[] ids = {"STU1", "LB1", "STU2", "", "STU3"};
        System.out.println(LibraryMemberP1.enrollBatch(ids, 3));
    }
}

class LibraryMemberP1 {
    String memberId;
    int borrowLimit;
    private int booksBorrowed = 0;

    public LibraryMemberP1(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException();
        }
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    public void borrowBook() {
        this.booksBorrowed++;
    }

    public int getBooksBorrowed() {
        return this.booksBorrowed;
    }

    public static String enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolled = 0;
        int rejected = 0;
        for (String id : memberIds) {
            try {
                new LibraryMemberP1(id, borrowLimit);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }
}

class StudentMemberP1 extends LibraryMemberP1 {
    String course;

    public StudentMemberP1(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }
}
