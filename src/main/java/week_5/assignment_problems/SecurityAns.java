package main.java.week_5.assignment_problems;


class LibraryMemberP4 {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;
    public LibraryMemberP4() {
    }
    public String getMembershipId() { return membershipId; }
    public void setMembershipId(String id) {
        if (this.membershipId == null) this.membershipId = id;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public boolean isPremiumMember() { return premiumMember; }
    public void setPremiumMember(boolean premium) { this.premiumMember = premium; }
    public void setSecurityAnswer(String answer) { this.securityAnswer = "hashed_" + answer; }
}
public class SecurityAns {
    public static void main(String[] args) {
        LibraryMemberP4 m = new LibraryMemberP4();
        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);
        System.out.println("\"" + m.getMembershipId() + "\"");
        m.setMembershipId("FAKE-0000");
        System.out.println("\"" + m.getMembershipId() + "\"");
        System.out.println(m.isPremiumMember());
        m.setSecurityAnswer("BlueMountain");
        System.out.println("(no observable output - no method anywhere on the class can retrieve this value again)");
    }
}