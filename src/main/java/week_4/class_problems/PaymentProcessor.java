package week_4.class_problems;

class FeeAccount {
}

class HostelFeeAccount extends FeeAccount {
}

public class PaymentProcessor {
    public static void processPayment(FeeAccount account, double amount) {
        if(account instanceof HostelFeeAccount) {
            System.out.println("Paid in two installments (hostel account)");
        } else {
            System.out.println("Paid in one go (day-scholar account)");
        }
    }
    public static void main(String[] args) {
        FeeAccount[] accounts = {
                new HostelFeeAccount(),
                new HostelFeeAccount(),
                new FeeAccount(),
                new FeeAccount()
        };
        double amount = 60000;
        int hostelCount = 0;
        int dayscholarCount = 0;
        for(FeeAccount acc : accounts) {
            processPayment(acc, amount);
            if(acc instanceof HostelFeeAccount) {
                hostelCount++;
            } else {
                dayscholarCount++;
            }
        }
        System.out.println("Hostel accounts processed: " + hostelCount + " | Day-scholar accounts processed: " + dayscholarCount);
    }
}