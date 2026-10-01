package main.java.week_7_problems.assignment_problems;

public class AssignmentProblem5 {
    public static void main(String[] args) {
        DeliveryDroneA5 d = new DeliveryDroneA5("DR-1");
        System.out.println(getLocationIfTrackable(d));

        ScoutDroneA5 s = new ScoutDroneA5("SC-1");
        System.out.println(getLocationIfTrackable(s));

        GroundRobotA5 g = new GroundRobotA5("GR-1");
        System.out.println(getLocationIfTrackable(g));
    }

    static String getLocationIfTrackable(Object o) {
        if (o instanceof TrackableA5) {
            TrackableA5 t = (TrackableA5) o;
            return t.getLocation();
        }
        return "Tracking not available";
    }
}

abstract class DroneA5 {
    public abstract String fly();
}

interface TrackableA5 {
    String getLocation();
}

class DeliveryDroneA5 extends DroneA5 implements TrackableA5 {
    private String id;

    public DeliveryDroneA5(String id) {
        this.id = id;
    }

    @Override
    public String fly() {
        return id + " flying to destination";
    }

    @Override
    public String getLocation() {
        return id + " at Sector 4";
    }
}

class ScoutDroneA5 extends DroneA5 {
    private String id;

    public ScoutDroneA5(String id) {
        this.id = id;
    }

    @Override
    public String fly() {
        return id + " scouting area";
    }
}

class GroundRobotA5 implements TrackableA5 {
    private String id;

    public GroundRobotA5(String id) {
        this.id = id;
    }

    @Override
    public String getLocation() {
        return id + " at Sector 4";
    }
}