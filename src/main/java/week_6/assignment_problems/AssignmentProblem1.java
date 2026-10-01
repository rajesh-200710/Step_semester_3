package main.java.week_6.assignment_problems;

public class AssignmentProblem1 {
    public static void main(String[] args) {
        try {
            new GymMemberA1("GM1", 1000);
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }

        PremiumMemberA1 p = new PremiumMemberA1("MEM01", 2000, "Coach Riya");
        p.attendSession();
        p.attendSession();
        System.out.println(p.getSessionsAttended());

        String[] ids = {"MEM1", "GM1", "MEM2", "", "MEM3"};
        System.out.println(GymMemberA1.signUpBatch(ids, 1000));
    }
}

class GymMemberA1 {
    String memberId;
    int monthlyFee;
    private int sessionsAttended = 0;

    public GymMemberA1(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException();
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    public void attendSession() {
        this.sessionsAttended++;
    }

    public int getSessionsAttended() {
        return this.sessionsAttended;
    }

    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;
        for (String id : memberIds) {
            try {
                new GymMemberA1(id, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }
}

class PremiumMemberA1 extends GymMemberA1 {
    String trainerName;

    public PremiumMemberA1(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }
}