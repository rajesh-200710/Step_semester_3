package main.java.week_6.assignment_problems;

public class AssignmentProblem5 {
    public static void main(String[] args) {
        GymMemberA5 m1 = new GymMemberA5(1000);
        System.out.println(m1.membershipNumber);
        System.out.println(GymMemberA5.getMembersEnrolled());

        System.out.println(GymMemberA5.isValidReferralCode("G45B"));
        System.out.println(GymMemberA5.isValidReferralCode("G4B"));
        System.out.println(GymMemberA5.isValidReferralCode("X45B"));

        m1.payFee(500);
        m1.payFee(500, "UPI");
        System.out.println(m1.getFeesPaid());

        GymMemberA5[] batch = {new GroupClassMemberA5(1500, "Zumba"), null, new GymMemberA5(1000)};
        System.out.println(processWeeklyCheckIn(batch));
    }

    public static String processWeeklyCheckIn(GymMemberA5[] members) {
        int processed = 0, skipped = 0, group = 0, individual = 0;
        for (GymMemberA5 member : members) {
            if (member == null) {
                skipped++;
            } else {
                processed++;
                if (member instanceof GroupClassMemberA5) {
                    group++;
                } else {
                    individual++;
                }
            }
        }
        return processed + " processed | " + skipped + " null skipped | " + group + " group | " + individual + " individual";
    }
}

class GymMemberA5 {
    final String membershipNumber;
    private static int membersEnrolled = 0;
    private int feesPaid = 0;
    int monthlyFee;

    public GymMemberA5(int monthlyFee) {
        this.monthlyFee = monthlyFee;
        membersEnrolled++;
        this.membershipNumber = "GYM-" + (2000 + membersEnrolled);
    }

    public void payFee(int amount) {
        this.feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        payFee(amount);
    }

    public int getFeesPaid() {
        return this.feesPaid;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) return false;
        if (code.charAt(0) != 'G') return false;
        if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) return false;
        return Character.isUpperCase(code.charAt(3));
    }
}

class GroupClassMemberA5 extends GymMemberA5 {
    String className;

    public GroupClassMemberA5(int monthlyFee, String className) {
        super(monthlyFee);
        this.className = className;
    }
}
