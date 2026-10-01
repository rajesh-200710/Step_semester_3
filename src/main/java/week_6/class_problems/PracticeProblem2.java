package main.java.week_6.class_problems;

public class PracticeProblem2 {
    public static void main(String[] args) {
        LibraryMemberP2 standard = new LibraryMemberP2("STU1", 3);
        StudentMemberP2 student = new StudentMemberP2("STU2", 3, "CSE");
        HonorsStudentMemberP2 honors = new HonorsStudentMemberP2("STU3", 3, "ECE", 2);
        FacultyMemberP2 faculty = new FacultyMemberP2("STU4", 5, "Physics");

        System.out.println(standard.displayInfo());
        System.out.println(student.displayInfo());
        System.out.println(honors.displayInfo());
        System.out.println(faculty.displayInfo());

        System.out.println(classifyGeneration(honors));
        System.out.println(classifyGeneration(faculty));

        student.borrowBook(); student.borrowBook();
        honors.borrowBook();
        faculty.borrowBook(); faculty.borrowBook(); faculty.borrowBook();

        LibraryMemberP2[] mix = {student, honors, faculty};
        System.out.println(getTotalBooksBorrowed(mix));
    }

    public static String classifyGeneration(LibraryMemberP2 member) {
        if (member instanceof HonorsStudentMemberP2) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof FacultyMemberP2) {
            return "Hierarchical sibling (independent branch)";
        }
        return "";
    }

    public static int getTotalBooksBorrowed(LibraryMemberP2[] members) {
        int total = 0;
        for (LibraryMemberP2 member : members) {
            if (member != null) {
                total += member.getBooksBorrowed();
            }
        }
        return total;
    }
}

class LibraryMemberP2 {
    String memberId;
    int borrowLimit;
    private int booksBorrowed = 0;

    public LibraryMemberP2(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    public void borrowBook() {
        this.booksBorrowed++;
    }

    public int getBooksBorrowed() {
        return this.booksBorrowed;
    }

    public String displayInfo() {
        return "General Member | Books Borrowed: " + getBooksBorrowed();
    }
}

class StudentMemberP2 extends LibraryMemberP2 {
    String course;

    public StudentMemberP2(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    public String displayInfo() {
        return "Student Member | Course: " + course + " | Books Borrowed: " + getBooksBorrowed();
    }
}

class HonorsStudentMemberP2 extends StudentMemberP2 {
    int bonusLimit;

    public HonorsStudentMemberP2(String memberId, int borrowLimit, String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    @Override
    public String displayInfo() {
        return "Honors Student Member | Course: " + course + " | Bonus Limit: " + bonusLimit + " | Books Borrowed: " + getBooksBorrowed();
    }
}

class FacultyMemberP2 extends LibraryMemberP2 {
    String department;

    public FacultyMemberP2(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    @Override
    public String displayInfo() {
        return "Faculty Member | Department: " + department + " | Books Borrowed: " + getBooksBorrowed();
    }
}