package main.java.week_5.assignment_problems;

class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;
    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = new String[bookIds.length];
        System.arraycopy(bookIds, 0, this.bookIds, 0, bookIds.length);
    }
    public String[] getBookIds() {
        String[] copy = new String[bookIds.length];
        System.arraycopy(bookIds, 0, copy, 0, bookIds.length);
        return copy;
    }
    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] updatedIds = getBookIds();
        if (index >= 0 && index < updatedIds.length) updatedIds[index] = newId;
        return new LoanReceipt(this.memberId, updatedIds);
    }
}
class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;
    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }
}
class CirculationLedger {
    static String branchCode;
    static {
        branchCode = "B-01";
    }
    static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0, nullSkipped = 0, ref = 0, reg = 0;
        for (LoanReceipt receipt : receipts) {
            if (receipt == null) nullSkipped++;
            else {
                processed++;
                if (receipt instanceof ReferenceOnlyLoanReceipt) ref++;
                else reg++;
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + ref + " reference-only | " + reg + " regular";
    }
}
public class Loan {
    public static void main(String[] args) {
        LoanReceipt r = new LoanReceipt("LIB-8841", new String[]{"BK-100", "BK-101"});
        String[] ids = r.getBookIds();
        ids[0] = "HACKED";
        System.out.println("\"" + r.getBookIds()[0] + "\"");
        LoanReceipt corrected = r.withCorrectedBookId(1, "BK-102");
        System.out.println("[\"" + r.getBookIds()[0] + "\", \"" + r.getBookIds()[1] + "\"]");
        System.out.println("[\"" + corrected.getBookIds()[0] + "\", \"" + corrected.getBookIds()[1] + "\"]");
        LoanReceipt[] receipts = {
                new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"}, "Reading Room 3"),
                null,
                new LoanReceipt("LIB-002", new String[]{"BK-201"})
        };
        System.out.println("\"" + CirculationLedger.processNightlyCirculation(receipts) + "\"");
    }
}