package main.java.week_6.assignment_problems;

import java.util.Arrays;

public class AssignmentProblem3 {
    public static void main(String[] args) {
        PremiumMemberA3 p = new PremiumMemberA3("MEM5", 2000, "Coach Riya");
        p.chargeLateFee(200);
        System.out.println(p.getTotalLateFees());

        int[] history = p.getLateFeeHistory();
        System.out.println(Arrays.toString(history));

        history[0] = 999;
        System.out.println(Arrays.toString(p.getLateFeeHistory()));
    }
}

class GymMemberA3 {
    String memberId;
    int monthlyFee;
    private int[] lateFeeHistory = new int[10];
    private int lateFeeCount = 0;

    public GymMemberA3(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    protected void chargeLateFee(int amount) {
        if (lateFeeCount < 10) {
            lateFeeHistory[lateFeeCount++] = amount;
        }
    }

    public int[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, lateFeeCount);
    }

    public int getTotalLateFees() {
        int total = 0;
        for (int i = 0; i < lateFeeCount; i++) {
            total += lateFeeHistory[i];
        }
        return total;
    }
}

class PremiumMemberA3 extends GymMemberA3 {
    String trainerName;

    public PremiumMemberA3(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }
}
