package main.java.week_8_problems.class_problems;

public class PracticeProblem2 {
    public static void main(String[] args) {
        EmployeeP2 john = new FullTimeP2("John");
        EmployeeP2 jane = new PartTimeP2("Jane");

        LeaveRequestP2 req1 = new LeaveRequestP2(john, "Jan 1-5");
        req1.approve();

        LeaveRequestP2 req2 = new LeaveRequestP2(jane, "Feb 10-11");
        req2.reject();

        req1.setToPending();
    }
}

abstract class EmployeeP2 {
    String name;
    public EmployeeP2(String name) { this.name = name; }
}
class FullTimeP2 extends EmployeeP2 { public FullTimeP2(String name) { super(name); } }
class PartTimeP2 extends EmployeeP2 { public PartTimeP2(String name) { super(name); } }

class LeaveRequestP2 {
    EmployeeP2 emp;
    String dates;
    String status;

    public LeaveRequestP2(EmployeeP2 emp, String dates) {
        this.emp = emp;
        this.dates = dates;
        this.status = "Pending";
        System.out.println("Leave request submitted for " + emp.name + " (" + dates + "). Status: " + status + ".");
    }

    public void approve() {
        if ("Pending".equals(status)) {
            status = "Approved";
            System.out.println(emp.name + "'s leave request (" + dates + ") approved. Status: " + status + ".");
        }
    }
    public void reject() {
        if ("Pending".equals(status)) {
            status = "Rejected";
            System.out.println(emp.name + "'s leave request (" + dates + ") rejected. Status: " + status + ".");
        }
    }
    public void setToPending() {
        if (!"Pending".equals(status)) {
            System.out.println("Cannot change leave request status from " + status + " to Pending.");
        }
    }
}
