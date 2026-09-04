package week_2.assignment_problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Assignment5 {
    public static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.split("\\s+");
        List<String> stopWords = Arrays.asList("the", "was", "and", "a", "is", "of", "in");
        ArrayList<String> uniqueWords = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();
        for(String word : words) {
            if(stopWords.contains(word) || word.isEmpty()) {
                continue;
            }
            int index = uniqueWords.indexOf(word);
            if(index != -1) {
                counts.set(index, counts.get(index) + 1);
            } else {
                uniqueWords.add(word);
                counts.add(1);
            }
        }
        for(int i = 0; i < uniqueWords.size() - 1; i++) {
            for(int j = i + 1; j < uniqueWords.size(); j++) {
                if(counts.get(j) > counts.get(i)) {
                    int tempCount = counts.get(i);
                    counts.set(i, counts.get(j));
                    counts.set(j, tempCount);
                    String tempWord = uniqueWords.get(i);
                    uniqueWords.set(i, uniqueWords.get(j));
                    uniqueWords.set(j, tempWord);
                }
            }
        }
        for(int i = 0; i < uniqueWords.size(); i++) {
            System.out.println(uniqueWords.get(i) + ": " + counts.get(i));
        }
    }
    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
