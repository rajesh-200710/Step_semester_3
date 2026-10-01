package main.java.week_8_problems.assignment_problems;

public class AssignmentProblem2 {
    public static void main(String[] args) {
        CodingAssignmentA2 linkedList = new CodingAssignmentA2("Linked List Lab", 50, 10);
        WrittenAssignmentA2 designEssay = new WrittenAssignmentA2("Design Essay", 50, 12);

        StudentA2 asha = new StudentA2("Asha");
        StudentA2 ravi = new StudentA2("Ravi");

        SubmissionA2 sub1 = new SubmissionA2(asha, linkedList, 10);
        SubmissionA2 sub2 = new SubmissionA2(ravi, designEssay, 14);

        sub1.grade(45);
        sub2.grade(40);

        SubmissionA2 sub3 = new SubmissionA2(asha, linkedList, 11);
    }
}

class StudentA2 {
    String name;
    public StudentA2(String name) { this.name = name; }
}

abstract class AssignmentA2 {
    String title;
    int maxMarks;
    int dueDay;

    public AssignmentA2(String title, int maxMarks, int dueDay) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDay = dueDay;
    }
    abstract double calculatePenalty(int lateDays);
}

class CodingAssignmentA2 extends AssignmentA2 {
    public CodingAssignmentA2(String title, int maxMarks, int dueDay) { super(title, maxMarks, dueDay); }
    double calculatePenalty(int lateDays) { return lateDays > 0 ? lateDays * 0.10 : 0; }
}

class WrittenAssignmentA2 extends AssignmentA2 {
    public WrittenAssignmentA2(String title, int maxMarks, int dueDay) { super(title, maxMarks, dueDay); }
    double calculatePenalty(int lateDays) { return lateDays > 0 ? lateDays * 0.20 : 0; }
}

class SubmissionA2 {
    private StudentA2 student;
    private AssignmentA2 assignment;
    private int submitDay;
    private String status;
    private static java.util.Set<String> gradedSet = new java.util.HashSet<>();

    public SubmissionA2(StudentA2 student, AssignmentA2 assignment, int submitDay) {
        String key = student.name + "-" + assignment.title;
        if (gradedSet.contains(key)) {
            System.out.println("Cannot resubmit: '" + assignment.title + "' has already been graded.");
            return;
        }
        this.student = student;
        this.assignment = assignment;
        this.submitDay = submitDay;
        this.status = "Submitted";

        int lateDays = submitDay - assignment.dueDay;
        String timing = lateDays > 0 ? lateDays + " days late" : "on time";
        System.out.println(student.name + "'s submission for '" + assignment.title + "' received (" + timing + "). Status: " + status + ".");
    }

    public void grade(int marksAwarded) {
        if (!status.equals("Submitted")) return;
        int lateDays = submitDay - assignment.dueDay;
        double penaltyPerc = assignment.calculatePenalty(Math.max(0, lateDays));
        int finalMarks = (int)(marksAwarded * (1.0 - penaltyPerc));
        this.status = "Graded";
        gradedSet.add(student.name + "-" + assignment.title);

        String penaltyText = lateDays > 0 ? " after " + (int)(penaltyPerc * 100) + "% late penalty" : "";
        System.out.println(student.name + " graded: " + finalMarks + "/" + assignment.maxMarks + penaltyText + ". Status: " + status + ".");
    }
}
