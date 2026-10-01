package main.java.week_7_problems.class_problems;

public class PracticeProblem1 {
    public static void main(String[] args) {
        ToyCarP1 c = new ToyCarP1("Speedster");
        System.out.println(c.makeSound());

        ToyRobotP1 r = new ToyRobotP1("Bolt");
        System.out.println(r.makeSound());

        System.out.println(c.getToyId());
        System.out.println(r.getToyId());
    }
}

abstract class ToyP1 {
    final String toyId;
    private static int counter = 1000;

    public ToyP1() {
        counter++;
        this.toyId = "TOY-" + counter;
    }

    public abstract String makeSound();

    public String getToyId() {
        return toyId;
    }
}

class ToyCarP1 extends ToyP1 {
    private String name;

    public ToyCarP1(String name) {
        super();
        this.name = name;
    }

    @Override
    public String makeSound() {
        return name + ": Vroom vroom!";
    }
}

class ToyRobotP1 extends ToyP1 {
    private String name;

    public ToyRobotP1(String name) {
        super();
        this.name = name;
    }

    @Override
    public String makeSound() {
        return name + ": Beep boop!";
    }
}
