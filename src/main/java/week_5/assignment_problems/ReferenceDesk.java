package main.java.week_5.assignment_problems;

public class ReferenceDesk {
    static String classifyAccess(String fieldModifier, String accessorContext) {
        if (accessorContext.equals("SAME_CLASS")) return "ALLOWED";
        if (accessorContext.equals("SAME_PACKAGE")) {
            if (fieldModifier.equals("private")) return "DENIED";
            return "ALLOWED";
        }
        if (accessorContext.equals("DIFFERENT_PACKAGE")) {
            if (fieldModifier.equals("public")) return "ALLOWED";
            return "DENIED";
        }
        if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
            if (fieldModifier.equals("public") || fieldModifier.equals("protected")) return "ALLOWED";
            return "DENIED";
        }
        if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {
            if (fieldModifier.equals("public")) return "ALLOWED";
            return "DENIED";
        }
        return "DENIED";
    }
    static String firstDeniedAttempt(String[][] attempts) {
        for (int i = 0; i < attempts.length; i++) {
            if (classifyAccess(attempts[i][0], attempts[i][1]).equals("DENIED")) {
                return attempts[i][0] + " via " + attempts[i][1] + " (attempt #" + (i + 1) + ")";
            }
        }
        return "None Denied";
    }
    public static void main(String[] args) {
        String[][] attempts1 = {
                {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
                {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
                {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println("\"" + firstDeniedAttempt(attempts1) + "\"");
        String[][] attempts2 = {
                {"public", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
                {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println("\"" + firstDeniedAttempt(attempts2) + "\"");
    }
}