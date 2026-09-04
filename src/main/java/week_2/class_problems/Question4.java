package week_2.class_problems;

public class Question4 {
    public static String maskPhoneNumber(String phone) {
        if(phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }
        for(int i = 0; i < phone.length(); i++) {
            if(!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }
        String last4 = phone.substring(6);
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX-").append(last4);
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
    }
}