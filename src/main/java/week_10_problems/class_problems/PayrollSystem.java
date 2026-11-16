package week_10_problems.class_problems;

import java.util.*;

abstract class Staff {
    protected String name;
    protected String type;

    public Staff(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public abstract int calculatePay();

    public String getName() {
        return name;
    }

    public String getPayslip() {
        return "Payslip [name=" + name + ", type=" + type + ", pay=" + calculatePay() + "]";
    }
}

class FullTime extends Staff {
    private int salary;

    public FullTime(String name, int salary) {
        super(name, "FullTime");
        this.salary = salary;
    }

    @Override
    public int calculatePay() {
        return salary;
    }
}

class PartTime extends Staff {
    private int hours;
    private int rate;

    public PartTime(String name, int hours, int rate) {
        super(name, "PartTime");
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public int calculatePay() {
        return hours * rate;
    }
}

class Intern extends Staff {
    private int stipend;

    public Intern(String name, int stipend) {
        super(name, "Intern");
        this.stipend = stipend;
    }

    @Override
    public int calculatePay() {
        return stipend;
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Staff> staffList = new ArrayList<>();

        while (sc.hasNext()) {
            String type = sc.next();
            if (type.equals("FullTime")) {
                String name = sc.next();
                int salary = sc.nextInt();
                staffList.add(new FullTime(name, salary));
            } else if (type.equals("PartTime")) {
                String name = sc.next();
                int hours = sc.nextInt();
                int rate = sc.nextInt();
                staffList.add(new PartTime(name, hours, rate));
            } else if (type.equals("Intern")) {
                String name = sc.next();
                int stipend = sc.nextInt();
                staffList.add(new Intern(name, stipend));
            }
        }
        sc.close();

        Staff[] staffArray = staffList.toArray(new Staff[0]);
        int totalPay = 0;
        int maxPay = -1;
        String topEarner = "";

        for (Staff s : staffArray) {
            System.out.println(s.getPayslip());
            int pay = s.calculatePay();
            totalPay += pay;
            if (pay > maxPay) {
                maxPay = pay;
                topEarner = s.getName();
            }
        }

        System.out.println("Total " + totalPay);
        System.out.println("top earner " + topEarner);
    }
}