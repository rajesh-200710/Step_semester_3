package main.java.week_8_problems.class_problems;

public class PracticeProblem1 {
    public static void main(String[] args) {
        CustomerP1 c1 = new CustomerP1("Customer 1");
        CustomerP1 c2 = new CustomerP1("Customer 2");
        CustomerP1 c3 = new CustomerP1("Customer 3");

        VehicleP1 sedan = new SedanP1("Sedan A");
        VehicleP1 suv = new SUVP1("SUV B");

        RentalSystemP1 sys = new RentalSystemP1();
        sys.rent(c1, sedan, 3);
        sys.rent(c2, sedan, 2);
        sys.returnVehicle(c1, sedan);
        sys.rent(c3, suv, 5);
    }
}

class CustomerP1 {
    String name;
    public CustomerP1(String name) { this.name = name; }
}

abstract class VehicleP1 {
    String id;
    boolean isAvailable = true;
    public VehicleP1(String id) { this.id = id; }
    abstract double calculateRent(int days);
}
class SedanP1 extends VehicleP1 {
    public SedanP1(String id) { super(id); }
    double calculateRent(int days) { return days * 50.0; }
}
class SUVP1 extends VehicleP1 {
    public SUVP1(String id) { super(id); }
    double calculateRent(int days) { return days * 80.0; }
}

class RentalSystemP1 {
    public void rent(CustomerP1 c, VehicleP1 v, int days) {
        if (!v.isAvailable) {
            System.out.println(v.id + " is currently unavailable.");
            return;
        }
        v.isAvailable = false;
        System.out.println(v.id + " rented successfully by " + c.name + ". Rental charge: $" + v.calculateRent(days));
    }
    public void returnVehicle(CustomerP1 c, VehicleP1 v) {
        v.isAvailable = true;
        System.out.println(v.id + " returned by " + c.name + ".");
    }
}
