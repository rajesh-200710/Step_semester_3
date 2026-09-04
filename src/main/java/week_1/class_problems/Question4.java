package week_1.class_problems;

public class Question4 {
    public static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256];
        for(int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        for(int i = 0; i < text.length(); i++) {
            if(freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return '\0';
    }
    public static void main(String[] args) {
        String[] tests = {"swiss", "aabbcc"};
        for(String t : tests) {
            char res = findFirstNonRepeatingChar(t);
            if(res != '\0') {
                System.out.println("\"" + t + "\" -> First Non-Repeating Character: '" + res + "'");
            } else {
                System.out.println("\"" + t + "\" -> No Non-Repeating Character Found");
            }
        }
    }
}