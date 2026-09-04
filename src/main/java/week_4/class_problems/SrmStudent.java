package week_4.class_problems;

public class SrmStudent {
    static String collegeName;
    static String academicYear;
    static {
        collegeName = "SRM";
        academicYear = "2026-2027";
        System.out.println("College info loaded");
    }
    String name;
    public SrmStudent(String name) {
        this.name = name;
        System.out.println("Student record created: " + name);
    }
    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};
        for(String n : names) {
            new SrmStudent(n);
        }
    }
}
