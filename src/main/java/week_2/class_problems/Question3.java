package week_2.class_problems;

public class Question3 {
    public static String validateFileExtension(String filename) {
        int lastDot = filename.lastIndexOf('.');
        if(lastDot == -1) {
            return "Rejected — invalid file type";
        }
        String ext = filename.substring(lastDot + 1);
        if(ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("docx") || ext.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }
    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));
    }
}
