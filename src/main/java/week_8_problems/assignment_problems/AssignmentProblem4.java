package main.java.week_8_problems.assignment_problems;

public class AssignmentProblem4 {
    public static void main(String[] args) {
        MemberA4 asha = new MemberA4("Asha");
        MemberA4 ravi = new MemberA4("Ravi");

        MembershipA4 m1 = new MembershipA4(asha, new QuarterlyPlanA4());
        MembershipA4 m2 = new MembershipA4(ravi, new MonthlyPlanA4());

        m1.checkIn();
        m1.freeze();
        m1.checkIn();

        m2.expire();
        m2.freeze();
    }
}

class MemberA4 {
    String name;
    public MemberA4(String name) { this.name = name; }
}

interface MembershipPlanA4 {
    String getName();
    double calculateFee();
}
class MonthlyPlanA4 implements MembershipPlanA4 {
    public String getName() { return "Monthly"; }
    public double calculateFee() { return 1000.0; }
}
class QuarterlyPlanA4 implements MembershipPlanA4 {
    public String getName() { return "Quarterly"; }
    public double calculateFee() { return 3000.0 * 0.90; }
}
class AnnualPlanA4 implements MembershipPlanA4 {
    public String getName() { return "Annual"; }
    public double calculateFee() { return 12000.0 * 0.75; }
}

class MembershipA4 {
    private MemberA4 member;
    private String status;

    public MembershipA4(MemberA4 member, MembershipPlanA4 plan) {
        this.member = member;
        this.status = "Active";
        System.out.printf("%s membership created for %s. Fee: %.2f. Status: %s.\n",
                plan.getName(), member.name, plan.calculateFee(), status);
    }

    public void checkIn() {
        if ("Active".equals(status)) {
            System.out.println(member.name + " checked in successfully.");
        } else {
            System.out.println("Check-in denied: " + member.name + "'s membership is " + status + ".");
        }
    }

    public void freeze() {
        if ("Expired".equals(status)) {
            System.out.println("Cannot freeze an Expired membership.");
            return;
        }
        this.status = "Frozen";
        System.out.println(member.name + "'s membership frozen. Status: Frozen.");
    }

    public void expire() {
        this.status = "Expired";
        System.out.println(member.name + "'s membership expired. Status: Expired.");
    }
}