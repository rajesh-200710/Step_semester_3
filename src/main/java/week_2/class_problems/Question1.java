package week_2.class_problems;

public class Question1 {
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        String lower = text.toLowerCase();
        for(int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if(c >= 'a' && c <= 'z') {
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }
    public static void main(String[] args) {
        countVowelsAndConsonants("Java Programming");
    }
}