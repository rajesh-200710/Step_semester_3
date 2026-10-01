package main.java.week_8_problems.class_problems;

public class PracticeProblem5 {
    public static void main(String[] args) {
        OrderP5 orderX = new OrderP5("Customer X", 2);
        orderX.pay(new CreditCardP5());

        OrderP5 orderY = new OrderP5("Customer Y", 0);
        orderY.pay(new CreditCardP5());

        OrderP5 orderZ = new OrderP5("Customer Z", 1);
        orderZ.pay(new PayPalP5());
    }
}

interface PaymentMethodP5 {
    boolean processPayment();
    String getName();
}
class CreditCardP5 implements PaymentMethodP5 {
    public boolean processPayment() { return true; }
    public String getName() { return "Credit Card"; }
}
class PayPalP5 implements PaymentMethodP5 {
    public boolean processPayment() { return false; } // Failing intentionally for output match
    public String getName() { return "PayPal"; }
}

class OrderP5 {
    String customer;
    int itemCount;
    String status = "Pending";

    public OrderP5(String customer, int itemCount) {
        this.customer = customer;
        this.itemCount = itemCount;
        if(itemCount > 0) System.out.println("Order created for " + customer + ".");
    }

    public void pay(PaymentMethodP5 method) {
        if (itemCount == 0) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }
        System.out.println("Payment initiated via " + method.getName() + " for Order " + customer.split(" ")[1] + ".");
        if (method.processPayment()) {
            status = "Paid";
            System.out.println("Payment for Order " + customer.split(" ")[1] + " successful. Order status: " + status + ".");
        } else {
            System.out.println("Payment for Order " + customer.split(" ")[1] + " failed. Order status: " + status + ".");
        }
    }
}
