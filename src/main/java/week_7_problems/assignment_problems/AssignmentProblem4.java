package main.java.week_7_problems.assignment_problems;

public class AssignmentProblem4 {
    public static void main(String[] args) {
        TabletA4 t = new TabletA4("TAB-5");
        System.out.println(t.operate());
        System.out.println(t.charge());
        System.out.println(t.charge(30));
    }
}

abstract class ClassroomDeviceA4 {
    public abstract String operate();
}

interface ChargeableA4 {
    String charge();
    String charge(int minutes);
}

class TabletA4 extends ClassroomDeviceA4 implements ChargeableA4 {
    private String assetTag;

    public TabletA4(String assetTag) {
        this.assetTag = assetTag;
    }

    @Override
    public String operate() {
        return "Tablet " + assetTag + " displaying lesson";
    }

    @Override
    public String charge() {
        return assetTag + " charging";
    }

    @Override
    public String charge(int minutes) {
        return assetTag + " charging for " + minutes + " minutes";
    }
}
