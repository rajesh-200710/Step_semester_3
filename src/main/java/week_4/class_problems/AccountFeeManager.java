package week_4.class_problems;

public class AccountFeeManager {
    public final double calculateLateFee(int daysLate) {
        return daysLate * 2200.0;
    }
    public final void printSummary(String regNo, double totalFee, int daysLate) {
        if(daysLate <= 0) {
            System.out.println(regNo + " - On time, no late fee");
        } else {
            double fee = calculateLateFee(daysLate);
            System.out.println(regNo + " | Total Fee: Rs " + (totalFee + fee) + " | Late Fee: Rs " + fee);
        }
    }
    public static void main(String[] args) {
        String[] regNos = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000, 150000, 180000, 220000};
        int[] daysLate = {10, 0, -2, 5};
        AccountFeeManager manager = new AccountFeeManager();
        for(int i = 0; i < regNos.length; i++) {
            manager.printSummary(regNos[i], totalFees[i], daysLate[i]);
        }
    }
}