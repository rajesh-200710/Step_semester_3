package main.java.week_6.assignment_problems;

public class AssignmentProblem4 {
    public static void main(String[] args) {
        GymMemberA4[] arr = {
                new GymMemberA4("MEM6", 1000),
                new PremiumMemberA4("MEM7", 2000, "Coach Riya")
        };
        System.out.println(batchPrint(arr));

        try {
            GymMemberA4 plain = new GymMemberA4("MEM8", 1000);
            PremiumMemberA4 bad = (PremiumMemberA4) plain;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException at runtime");
        }
    }

    public static String batchPrint(GymMemberA4[] members) {
        StringBuilder sb = new StringBuilder();
        for (GymMemberA4 member : members) {
            if (member != null) {
                sb.append(member.displayInfo());
                if (member instanceof PremiumMemberA4) {
                    PremiumMemberA4 pm = (PremiumMemberA4) member;
                    sb.append(" [Trainer via downcast: ").append(pm.trainerName).append("]");
                }
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
}

class GymMemberA4 {
    String memberId;
    int monthlyFee;

    public GymMemberA4(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    public String displayInfo() {
        return "Standard | Sessions: 0";
    }
}

class PremiumMemberA4 extends GymMemberA4 {
    String trainerName;

    public PremiumMemberA4(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    public String displayInfo() {
        return "Premium | Trainer: " + trainerName + " | Sessions: 0";
    }
}