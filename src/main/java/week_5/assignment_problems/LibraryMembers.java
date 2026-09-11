package main.java.week_5.assignment_problems;

class LibraryMember {
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;
}
public class LibraryMembers {
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
        return "DENIED";
    }
    static String summarizeByModifier(String[][] attempts) {
        int privAllowed = 0, privDenied = 0;
        int defAllowed = 0, defDenied = 0;
        int protAllowed = 0, protDenied = 0;
        int pubAllowed = 0, pubDenied = 0;
        for (String[] attempt : attempts) {
            String mod = attempt[0];
            String res = classifyAccess(mod, attempt[1]);
            if (mod.equals("private")) { if (res.equals("ALLOWED")) privAllowed++; else privDenied++; }
            else if (mod.equals("default")) { if (res.equals("ALLOWED")) defAllowed++; else defDenied++; }
            else if (mod.equals("protected")) { if (res.equals("ALLOWED")) protAllowed++; else protDenied++; }
            else if (mod.equals("public")) { if (res.equals("ALLOWED")) pubAllowed++; else pubDenied++; }
        }
        return "private: " + privAllowed + " allowed / " + privDenied + " denied\n" +
                "default: " + defAllowed + " allowed / " + defDenied + " denied\n" +
                "protected: " + protAllowed + " allowed / " + protDenied + " denied\n" +
                "public: " + pubAllowed + " allowed / " + pubDenied + " denied";
    }
    public static void main(String[] args) {
        System.out.println("\"" + classifyAccess("private", "SAME_CLASS") + "\"");
        System.out.println("\"" + classifyAccess("protected", "DIFFERENT_PACKAGE") + "\"");
        String[][] attempts = {
                {"private", "SAME_CLASS"},
                {"private", "SAME_PACKAGE"},
                {"default", "SAME_PACKAGE"},
                {"default", "DIFFERENT_PACKAGE"},
                {"protected", "SAME_PACKAGE"},
                {"protected", "SAME_CLASS"},
                {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println("\"" + summarizeByModifier(attempts) + "\"");
    }
}