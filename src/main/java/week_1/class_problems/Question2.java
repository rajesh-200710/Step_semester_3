package week_1.class_problems;

public class Question2 {
    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while(left < right) {
            if(text.charAt(left) != text.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public static boolean isPalindromeRecursive(String text) {
        if(text.length() <= 1) return true;
        if(text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }
    public static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();
        char[] rev = new char[arr.length];
        for(int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }
        return text.equals(new String(rev));
    }
    public static void main(String[] args) {
        String[] tests = {"madam", "hello"};
        for(String t : tests) {
            System.out.println("\"" + t + "\"");
            System.out.println("Iterative: " + (isPalindromeIterative(t) ? "Palindrome" : "Not Palindrome"));
            System.out.println("Recursive: " + (isPalindromeRecursive(t) ? "Palindrome" : "Not Palindrome"));
            System.out.println("Array Reversal: " + (isPalindromeArrayReversal(t) ? "Palindrome" : "Not Palindrome"));
        }
    }
}