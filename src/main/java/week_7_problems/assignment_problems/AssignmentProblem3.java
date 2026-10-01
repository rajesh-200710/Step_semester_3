package main.java.week_7_problems.assignment_problems;

public class AssignmentProblem3 {
    public static void main(String[] args) {
        CuttingToolA3 c = new CuttingToolA3();
        System.out.println(c.use());

        PrunerA3 p = new PrunerA3();
        System.out.println(p.use());
    }
}

abstract class GardenToolA3 {
    public abstract String use();
}

class CuttingToolA3 extends GardenToolA3 {
    public CuttingToolA3() {
        super();
    }

    @Override
    public String use() {
        return "Using the tool in the garden, blade sharpened first";
    }
}

class PrunerA3 extends CuttingToolA3 {
    public PrunerA3() {
        super();
    }

    @Override
    public String use() {
        return super.use() + ", then trimming branches precisely";
    }
}
