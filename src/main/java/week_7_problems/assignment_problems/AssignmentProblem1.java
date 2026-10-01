package main.java.week_7_problems.assignment_problems;

public class AssignmentProblem1 {
    public static void main(String[] args) {
        AlarmClockA1 a = new AlarmClockA1("7:00 AM");
        System.out.println(a.ring());

        DoorbellA1 d = new DoorbellA1("Front Door");
        System.out.println(d.ring());

        ringAll(new RingableA1[]{a, d});
    }

    static void ringAll(RingableA1[] devices) {
        for (RingableA1 device : devices) {
            System.out.println(device.ring());
        }
    }
}

interface RingableA1 {
    String ring();
}

class AlarmClockA1 implements RingableA1 {
    private String time;

    public AlarmClockA1(String time) {
        this.time = time;
    }

    @Override
    public String ring() {
        return "Alarm ringing for " + time;
    }
}

class DoorbellA1 implements RingableA1 {
    private String location;

    public DoorbellA1(String location) {
        this.location = location;
    }

    @Override
    public String ring() {
        return "Doorbell ringing at " + location;
    }
}