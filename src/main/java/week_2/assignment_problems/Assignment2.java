package week_2.assignment_problems;

public class Assignment2 {
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            StringBuilder revWord = new StringBuilder(words[i]);
            result.append(revWord.reverse().toString());
            if(i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club"));
    }
}