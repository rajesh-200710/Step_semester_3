package week_1.assignment_problems;

public class Assignment2 {
    public static void checkTypingAccuracy(String original, String typed) {
        int matches = 0;
        int total = original.length();
        int firstMismatch = -1;
        for(int i = 0; i < total; i++) {
            if(original.charAt(i) == typed.charAt(i)) {
                matches++;
            } else if(firstMismatch == -1) {
                firstMismatch = i + 1;
            }
        }
        double accuracy = ((double) matches / total) * 100;
        if(firstMismatch == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches\n", matches, total, accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')\n", matches, total, accuracy, firstMismatch, original.charAt(firstMismatch - 1), typed.charAt(firstMismatch - 1));
        }
    }
    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}