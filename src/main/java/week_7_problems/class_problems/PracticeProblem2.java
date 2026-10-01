package main.java.week_7_problems.class_problems;

class AssignmentProblem2 {
    public static void main(String[] args) {
        PaintingA2 p = new PaintingA2("Sunset Fields");
        System.out.println(p.describe());

        SculptureA2 s = new SculptureA2("The Thinker II");
        System.out.println(s.describe());
    }
}

abstract class ArtPieceA2 {
    final String pieceId;
    private static int counter = 1000;

    public ArtPieceA2() {
        counter++;
        this.pieceId = "ART-" + counter;
    }

    public abstract String describe();

    public String getPieceId() {
        return pieceId;
    }
}

class PaintingA2 extends ArtPieceA2 {
    private String title;

    public PaintingA2(String title) {
        super();
        this.title = title;
    }

    @Override
    public String describe() {
        return "Painting: " + title + ", framed on canvas";
    }
}

class SculptureA2 extends ArtPieceA2 {
    private String title;

    public SculptureA2(String title) {
        super();
        this.title = title;
    }

    @Override
    public String describe() {
        return "Sculpture: " + title + ", carved from stone";
    }
}
