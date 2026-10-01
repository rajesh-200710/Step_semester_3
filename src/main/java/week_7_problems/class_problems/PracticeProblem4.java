package main.java.week_7_problems.class_problems;

public class PracticeProblem4 {
    public static void main(String[] args) {
        BlenderP4 b = new BlenderP4();
        b.setSpeedLevel(3);
        System.out.println(b.getSpeedLevel());

        b.setSpeedLevel(9);
        System.out.println("rejected, speed level stays " + b.getSpeedLevel());

        System.out.println(b.prepare());
        System.out.println(b.clean());
    }
}

abstract class KitchenToolP4 {
    private int speedLevel = 1;

    public abstract String prepare();

    public int getSpeedLevel() {
        return speedLevel;
    }

    public void setSpeedLevel(int speedLevel) {
        if (speedLevel >= 1 && speedLevel <= 5) {
            this.speedLevel = speedLevel;
        }
    }
}

interface WashableP4 {
    String clean();
}

class BlenderP4 extends KitchenToolP4 implements WashableP4 {
    @Override
    public String prepare() {
        return "Blending at speed " + getSpeedLevel();
    }

    @Override
    public String clean() {
        return "Blender rinsed and dried";
    }
}
