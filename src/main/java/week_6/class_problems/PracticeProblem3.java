package main.java.week_6.class_problems;

import java.util.Arrays;

public class PracticeProblem3 {
    public static void main(String[] args) {
        StudentMemberP3 s = new StudentMemberP3("STU5", 3, "CSE");
        s.chargeFine(100);
        System.out.println(s.getTotalFine());

        int[] history = s.getFineHistory();
        System.out.println(Arrays.toString(history));

        // Testing defensive copy
        history[0] = 999;
        System.out.println(Arrays.toString(s.getFineHistory()));
    }
}

class LibraryMemberP3 {
    String memberId;
    int borrowLimit;
    private int[] fineHistory = new int[10];
    private int fineCount = 0;

    public LibraryMemberP3(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    protected void chargeFine(int amount) {
        if (fineCount < 10) {
            fineHistory[fineCount++] = amount;
        }
    }

    public int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    public int getTotalFine() {
        int total = 0;
        for (int i = 0; i < fineCount; i++) {
            total += fineHistory[i];
        }
        return total;
    }
}

class StudentMemberP3 extends LibraryMemberP3 {
    String course;

    public StudentMemberP3(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}
