package main.java.week_8_problems.assignment_problems;

public class AssignmentProblem1 {
    public static void main(String[] args) {
        StudentA1 asha = new StudentA1("Asha");
        StudentA1 ravi = new StudentA1("Ravi");
        StudentA1 neha = new StudentA1("Neha");

        MachineA1 m1 = new MachineA1("M1");
        MachineA1 m2 = new MachineA1("M2");

        m1.startCycle(asha, new QuickWashA1());
        m1.startCycle(ravi, new HeavyWashA1());
        m2.startCycle(ravi, new HeavyWashA1());

        m1.completeCycle();
        m1.startCycle(neha, new NormalWashA1());
    }
}

class StudentA1 {
    String name;
    public StudentA1(String name) { this.name = name; }
}

interface WashTypeA1 {
    String getName();
    int getDuration();
    double getCharge();
}

class QuickWashA1 implements WashTypeA1 {
    public String getName() { return "Quick"; }
    public int getDuration() { return 30; }
    public double getCharge() { return 20.00; }
}

class NormalWashA1 implements WashTypeA1 {
    public String getName() { return "Normal"; }
    public int getDuration() { return 45; }
    public double getCharge() { return 30.00; }
}

class HeavyWashA1 implements WashTypeA1 {
    public String getName() { return "Heavy"; }
    public int getDuration() { return 60; }
    public double getCharge() { return 45.00; }
}

class MachineA1 {
    private String id;
    private boolean isBusy;

    public MachineA1(String id) {
        this.id = id;
        this.isBusy = false;
    }

    public void startCycle(StudentA1 student, WashTypeA1 type) {
        if (isBusy) {
            System.out.println("Machine " + id + " is currently busy.");
            return;
        }
        this.isBusy = true;
        System.out.printf("%s wash started on %s for %s (%d min). Charge: %.2f.\n",
                type.getName(), id, student.name, type.getDuration(), type.getCharge());
    }

    public void completeCycle() {
        this.isBusy = false;
        System.out.println(id + " cycle completed. " + id + " is now free.");
    }
}
