package main.java.week_7_problems.class_problems;

public class PracticeProblem5 {
    public static void main(String[] args) {
        ParcelNoteP5 p = new ParcelNoteP5("TRK-1");
        System.out.println(p.confirmDelivery());
        System.out.println(p.confirmDelivery("J. Smith"));

        DeliveryNoteP5 ref = p;
        logAll(new DeliveryNoteP5[]{ref, new LetterNoteP5("TRK-2")});
    }

    static void logAll(DeliveryNoteP5[] notes) {
        for (DeliveryNoteP5 note : notes) {
            System.out.println(note.confirmDelivery());
        }
    }
}

abstract class DeliveryNoteP5 {
    public abstract String confirmDelivery();

    public String confirmDelivery(String signature) {
        return confirmDelivery() + ", signed by " + signature;
    }
}

class ParcelNoteP5 extends DeliveryNoteP5 {
    private String trackingId;

    public ParcelNoteP5(String trackingId) {
        this.trackingId = trackingId;
    }

    @Override
    public String confirmDelivery() {
        return "Parcel " + trackingId + " delivered";
    }
}

class LetterNoteP5 extends DeliveryNoteP5 {
    private String trackingId;

    public LetterNoteP5(String trackingId) {
        this.trackingId = trackingId;
    }

    @Override
    public String confirmDelivery() {
        return "Letter " + trackingId + " delivered";
    }
}