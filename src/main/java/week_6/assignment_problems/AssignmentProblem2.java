package main.java.week_6.assignment_problems;

public class AssignmentProblem2 {
    public static void main(String[] args) {
        GymMemberA2 standard = new GymMemberA2("MEM1", 1000);
        PremiumMemberA2 premium = new PremiumMemberA2("MEM2", 2000, "Coach Riya");
        EliteMemberA2 elite = new EliteMemberA2("MEM3", 3000, "Coach Arjun", "L12");
        GroupClassMemberA2 group = new GroupClassMemberA2("MEM4", 1500, "Zumba");

        System.out.println(standard.displayInfo());
        System.out.println(premium.displayInfo());
        System.out.println(elite.displayInfo());
        System.out.println(group.displayInfo());

        System.out.println(classifyGeneration(elite));
        System.out.println(classifyGeneration(group));

        premium.attendSession(); premium.attendSession(); premium.attendSession();
        elite.attendSession(); elite.attendSession();
        group.attendSession(); group.attendSession(); group.attendSession(); group.attendSession();

        GymMemberA2[] mix = {premium, elite, group};
        System.out.println(getTotalSessionsAttended(mix));
    }

    public static String classifyGeneration(GymMemberA2 member) {
        if (member instanceof EliteMemberA2) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof GroupClassMemberA2) {
            return "Hierarchical sibling (independent branch)";
        }
        return "";
    }

    public static int getTotalSessionsAttended(GymMemberA2[] members) {
        int total = 0;
        for (GymMemberA2 member : members) {
            if (member != null) {
                total += member.getSessionsAttended();
            }
        }
        return total;
    }
}

class GymMemberA2 {
    String memberId;
    int monthlyFee;
    private int sessionsAttended = 0;

    public GymMemberA2(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    public void attendSession() {
        this.sessionsAttended++;
    }

    public int getSessionsAttended() {
        return this.sessionsAttended;
    }

    public String displayInfo() {
        return "Standard Member | Sessions: " + getSessionsAttended();
    }
}

class PremiumMemberA2 extends GymMemberA2 {
    String trainerName;

    public PremiumMemberA2(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    public String displayInfo() {
        return "Premium Member | Trainer: " + trainerName + " | Sessions: " + getSessionsAttended();
    }
}

class EliteMemberA2 extends PremiumMemberA2 {
    String lockerNumber;

    public EliteMemberA2(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    public String displayInfo() {
        return "Elite Member | Trainer: " + trainerName + " | Locker: " + lockerNumber + " | Sessions: " + getSessionsAttended();
    }
}

class GroupClassMemberA2 extends GymMemberA2 {
    String className;

    public GroupClassMemberA2(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    @Override
    public String displayInfo() {
        return "Group Class Member | Class: " + className + " | Sessions: " + getSessionsAttended();
    }
}