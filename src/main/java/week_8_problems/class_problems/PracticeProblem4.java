package main.java.week_8_problems.class_problems;

public class PracticeProblem4 {
    public static void main(String[] args) {
        RoomP4 std = new StandardP4("Standard Room 101");
        RoomP4 deluxe = new DeluxeP4("Deluxe Room 201");

        HotelSystemP4 sys = new HotelSystemP4();
        sys.checkAvailability(std, "Jan 1-5");
        sys.reserve("Customer A", std, "Jan 1-5");
        sys.reserve("Customer B", std, "Jan 3-7");
        sys.cancel("Customer A", std, "Jan 1-5");
        sys.reserve("Customer C", deluxe, "Feb 10-12");
    }
}

abstract class RoomP4 {
    String id;
    boolean isAvailable = true;
    public RoomP4(String id) { this.id = id; }
}
class StandardP4 extends RoomP4 { public StandardP4(String id) { super(id); } }
class DeluxeP4 extends RoomP4 { public DeluxeP4(String id) { super(id); } }

class HotelSystemP4 {
    public void checkAvailability(RoomP4 room, String dates) {
        if (room.isAvailable) System.out.println(room.id + " is available from " + dates + ".");
    }
    public void reserve(String customer, RoomP4 room, String dates) {
        if (!room.isAvailable) {
            System.out.println(room.id + " is not available from " + dates + ".");
            return;
        }
        room.isAvailable = false;
        System.out.println("Reservation confirmed for " + customer + ", " + room.id + " (" + dates + "). Price: $X.");
    }
    public void cancel(String customer, RoomP4 room, String dates) {
        room.isAvailable = true;
        System.out.println("Reservation for " + customer + ", " + room.id + " (" + dates + ") cancelled successfully.");
    }
}
