package week_10_problems.class_problems;

import java.util.*;

interface Chargeable {
    void bookChargingBay();
}

abstract class Vehicle {
    protected String passNumber;
    protected String owner;
    protected String type;

    public Vehicle(String passNumber, String owner, String type) {
        this.passNumber = passNumber;
        this.owner = owner;
        this.type = type;
    }

    public abstract int getPassFee();

    public String getPassNumber() {
        return passNumber;
    }

    public String getType() {
        return type;
    }
}

class Bike extends Vehicle {
    public Bike(String passNumber, String owner) {
        super(passNumber, owner, "Bike");
    }

    @Override
    public int getPassFee() {
        return 300;
    }
}

class Car extends Vehicle {
    public Car(String passNumber, String owner) {
        super(passNumber, owner, "Car");
    }

    @Override
    public int getPassFee() {
        return 1000;
    }
}

class EBike extends Vehicle implements Chargeable {
    public EBike(String passNumber, String owner) {
        super(passNumber, owner, "E-Bike");
    }

    @Override
    public int getPassFee() {
        return 300;
    }

    @Override
    public void bookChargingBay() {
        System.out.println(passNumber + " charging bay allotted");
    }
}

class ECar extends Vehicle implements Chargeable {
    public ECar(String passNumber, String owner) {
        super(passNumber, owner, "ECar");
    }

    @Override
    public int getPassFee() {
        return 1000;
    }

    @Override
    public void bookChargingBay() {
        System.out.println(passNumber + " charging bay allotted");
    }
}

public class CampusVehicleSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Vehicle> registry = new HashMap<>();

        while (sc.hasNext()) {
            String op = sc.next();
            if (op.equals("PASS")) {
                String type = sc.next();
                String passNumber = sc.next();
                String owner = sc.next();

                Vehicle v = null;
                switch (type) {
                    case "Bike":
                        v = new Bike(passNumber, owner);
                        break;
                    case "Car":
                        v = new Car(passNumber, owner);
                        break;
                    case "EBike":
                    case "E-Bike":
                        v = new EBike(passNumber, owner);
                        break;
                    case "ECar":
                    case "E-Car":
                        v = new ECar(passNumber, owner);
                        break;
                }

                if (v != null) {
                    registry.put(passNumber, v);
                    System.out.println(passNumber + " (" + v.getType() + ") pass fee " + v.getPassFee());
                }
            } else if (op.equals("CHARGE")) {
                String passNumber = sc.next();
                Vehicle v = registry.get(passNumber);
                if (v instanceof Chargeable) {
                    ((Chargeable) v).bookChargingBay();
                } else if (v != null) {
                    System.out.println(passNumber + " rejected: charging unsupported");
                }
            }
        }
        sc.close();
    }
}
