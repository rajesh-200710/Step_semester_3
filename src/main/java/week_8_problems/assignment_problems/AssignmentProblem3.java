package main.java.week_8_problems.assignment_problems;

import java.util.*;

public class AssignmentProblem3 {
    public static void main(String[] args) {
        CustomerA3 asha = new CustomerA3("Asha");
        CustomerA3 ravi = new CustomerA3("Ravi");
        CustomerA3 neha = new CustomerA3("Neha");
        ShowA3 show = new ShowA3("7 PM");

        SeatA3 a1 = new RegularSeatA3("A1");
        SeatA3 a2 = new RegularSeatA3("A2");
        SeatA3 f5 = new PremiumSeatA3("F5");
        SeatA3 r1 = new ReclinerSeatA3("R1");

        BookingA3 b1 = show.book(asha, Arrays.asList(a1, a2, f5));
        show.book(ravi, Arrays.asList(a2));
        BookingA3 b2 = show.book(ravi, Arrays.asList(r1));

        if (b1 != null) show.cancel(b1);
        show.book(neha, Arrays.asList(a2));
    }
}

class CustomerA3 {
    String name;
    public CustomerA3(String name) { this.name = name; }
}

abstract class SeatA3 {
    String id;
    public SeatA3(String id) { this.id = id; }
    abstract double getPrice();
}

class RegularSeatA3 extends SeatA3 {
    public RegularSeatA3(String id) { super(id); }
    double getPrice() { return 150.0; }
}
class PremiumSeatA3 extends SeatA3 {
    public PremiumSeatA3(String id) { super(id); }
    double getPrice() { return 250.0; }
}
class ReclinerSeatA3 extends SeatA3 {
    public ReclinerSeatA3(String id) { super(id); }
    double getPrice() { return 400.0; }
}

class BookingA3 {
    CustomerA3 customer;
    List<SeatA3> seats;
    double total;
    public BookingA3(CustomerA3 customer, List<SeatA3> seats) {
        this.customer = customer;
        this.seats = seats;
        this.total = seats.stream().mapToDouble(SeatA3::getPrice).sum();
    }
}

class ShowA3 {
    String time;
    Set<String> bookedSeats = new HashSet<>();

    public ShowA3(String time) { this.time = time; }

    public BookingA3 book(CustomerA3 c, List<SeatA3> seats) {
        if (seats.size() > 6) return null;
        for (SeatA3 s : seats) {
            if (bookedSeats.contains(s.id)) {
                System.out.println("Seat " + s.id + " is already booked for this show.");
                return null;
            }
        }
        for (SeatA3 s : seats) bookedSeats.add(s.id);
        BookingA3 b = new BookingA3(c, seats);
        List<String> sIds = new ArrayList<>();
        for(SeatA3 s : seats) sIds.add(s.id);
        System.out.printf("Booking confirmed for %s: %s. Total: %.2f.\n", c.name, String.join(", ", sIds), b.total);
        return b;
    }

    public void cancel(BookingA3 b) {
        List<String> sIds = new ArrayList<>();
        for (SeatA3 s : b.seats) {
            bookedSeats.remove(s.id);
            sIds.add(s.id);
        }
        System.out.println(b.customer.name + "'s booking cancelled. Seats " + String.join(", ", sIds) + " released.");
    }
}
