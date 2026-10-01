package main.java.week_6.class_problems;

public class PracticeProblem5 {
    public static void main(String[] args) {
        LibraryMemberP5 m1 = new LibraryMemberP5(3);
        System.out.println(m1.memberNumber);
        System.out.println(LibraryMemberP5.getMembersEnrolled());

        System.out.println(LibraryMemberP5.isValidRenewalCode("R12A"));
        System.out.println(LibraryMemberP5.isValidRenewalCode("R1A"));
        System.out.println(LibraryMemberP5.isValidRenewalCode("X12A"));

        m1.borrowBook();
        m1.borrowBook("Fiction");
        System.out.println(m1.getBooksBorrowed());

        LibraryMemberP5[] batch = {
                new FacultyMemberP5(5, "Physics"),
                null,
                new LibraryMemberP5(3)
        };
        System.out.println(processNightlyAudit(batch));
    }

    public static String processNightlyAudit(LibraryMemberP5[] members) {
        int processed = 0, skipped = 0, faculty = 0, regular = 0;
        for (LibraryMemberP5 member : members) {
            if (member == null) {
                skipped++;
            } else {
                processed++;
                if (member instanceof FacultyMemberP5) {
                    faculty++;
                } else {
                    regular++;
                }
            }
        }
        return processed + " processed | " + skipped + " null skipped | " + faculty + " faculty | " + regular + " regular";
    }
}

class LibraryMemberP5 {
    final String memberNumber;
    private static int membersEnrolled = 0;
    int borrowLimit;
    private int booksBorrowed = 0;

    public LibraryMemberP5(int borrowLimit) {
        this.borrowLimit = borrowLimit;
        membersEnrolled++;
        this.memberNumber = "LIB-" + (100 + membersEnrolled);
    }

    public void borrowBook() {
        this.booksBorrowed++;
    }

    public void borrowBook(String genre) {
        borrowBook();
    }

    public int getBooksBorrowed() {
        return this.booksBorrowed;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }

    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) return false;
        if (code.charAt(0) != 'R') return false;
        if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) return false;
        return Character.isUpperCase(code.charAt(3));
    }
}

class FacultyMemberP5 extends LibraryMemberP5 {
    String department;

    public FacultyMemberP5(int borrowLimit, String department) {
        super(borrowLimit);
        this.department = department;
    }
}