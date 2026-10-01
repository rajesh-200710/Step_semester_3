package main.java.week_6.class_problems;

public class PracticeProblem4 {
    public static void main(String[] args) {
        LibraryMemberP4[] arr = {
                new LibraryMemberP4("LB5", 3),
                new StudentMemberP4("STU6", 3, "ECE")
        };
        System.out.println(batchPrint(arr));

        try {
            LibraryMemberP4 plain = new LibraryMemberP4("LB6", 3);
            StudentMemberP4 bad = (StudentMemberP4) plain;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException at runtime");
        }
    }

    public static String batchPrint(LibraryMemberP4[] members) {
        StringBuilder sb = new StringBuilder();
        for (LibraryMemberP4 member : members) {
            if (member != null) {
                sb.append(member.displayInfo());
                if (member instanceof StudentMemberP4) {
                    StudentMemberP4 sm = (StudentMemberP4) member;
                    sb.append(" [Course via downcast: ").append(sm.course).append("]");
                }
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
}

class LibraryMemberP4 {
    String memberId;
    int borrowLimit;

    public LibraryMemberP4(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    public String displayInfo() {
        return "General | Books: 0";
    }
}

class StudentMemberP4 extends LibraryMemberP4 {
    String course;

    public StudentMemberP4(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    public String displayInfo() {
        return "Student | Course: " + course + " | Books: 0";
    }
}
