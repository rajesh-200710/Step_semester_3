package main.java.week_5.assignment_problems;

final class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;
    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = new String[seatNumbers.length];
        System.arraycopy(seatNumbers, 0, this.seatNumbers, 0, seatNumbers.length);
    }
    public String[] getSeatNumbers() {
        String[] copy = new String[seatNumbers.length];
        System.arraycopy(seatNumbers, 0, copy, 0, seatNumbers.length);
        return copy;
    }
    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] updatedSeats = getSeatNumbers();
        if (index >= 0 && index < updatedSeats.length) updatedSeats[index] = newSeat;
        return new BookingReceipt(this.bookingId, updatedSeats);
    }
}
final class GroupBookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;
    private final int groupSize;
    public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
        this.bookingId = bookingId;
        this.seatNumbers = new String[seatNumbers.length];
        System.arraycopy(seatNumbers, 0, this.seatNumbers, 0, seatNumbers.length);
        this.groupSize = groupSize;
    }
}
public class BookingReceipts {
    static String processNightlySettlement(Object[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;
        for (Object receipt : receipts) {
            if (receipt == null) nullSkipped++;
            else {
                processed++;
                if (receipt instanceof GroupBookingReceipt) group++;
                else if (receipt instanceof BookingReceipt) individual++;
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped\n" + group + " group | " + individual + " individual";
    }
    public static void main(String[] args) {
        // Example 1
        BookingReceipt b = new BookingReceipt("CH-1001", new String[] {"A1", "A2"});
        String[] seats = b.getSeatNumbers();
        seats[0] = "X";
        System.out.println("\"" + b.getSeatNumbers()[0] + "\"");

        // Example 2
        BookingReceipt updated = b.withUpdatedSeat(1, "A3");
        System.out.println("[\"" + b.getSeatNumbers()[0] + "\", \"" + b.getSeatNumbers()[1] + "\"]");
        System.out.println("[\"" + updated.getSeatNumbers()[0] + "\", \"" + updated.getSeatNumbers()[1] + "\"]");

        // Example 3
        Object[] receipts = {
                new GroupBookingReceipt("CH-2002", new String[] {"B1", "B2"}, 2),
                null,
                new BookingReceipt("CH-3003", new String[] {"C1"})
        };
        System.out.println(processNightlySettlement(receipts));
    }
}