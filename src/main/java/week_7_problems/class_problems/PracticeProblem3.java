package main.java.week_7_problems.class_problems;

public class PracticeProblem3 {
    public static void main(String[] args) {
        StringInstrumentP3 s = new StringInstrumentP3();
        System.out.println(s.play());

        ViolinP3 v = new ViolinP3();
        System.out.println(v.play());
    }
}

abstract class InstrumentP3 {
    public abstract String play();
}

class StringInstrumentP3 extends InstrumentP3 {
    public StringInstrumentP3() {
        super();
    }

    @Override
    public String play() {
        return "Strumming the strings";
    }
}

class ViolinP3 extends StringInstrumentP3 {
    public ViolinP3() {
        super();
    }

    @Override
    public String play() {
        return super.play() + ", with a bow drawn across four strings";
    }
}