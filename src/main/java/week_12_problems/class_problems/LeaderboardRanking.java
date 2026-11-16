package week_12_problems.class_problems;

import java.util.*;

class Participant {
    String name;
    int score;

    public Participant(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class LeaderboardRanking {
    public static void insertionSort(List<Participant> list) {
        for (int i = 1; i < list.size(); i++) {
            Participant key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).score < key.score) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Participant> participants = new ArrayList<>();

        while (sc.hasNext()) {
            String name = sc.next();
            if (sc.hasNextInt()) {
                int score = sc.nextInt();
                participants.add(new Participant(name, score));
            }
        }
        sc.close();

        insertionSort(participants);

        int rank = 1;
        for (int i = 0; i < participants.size(); i++) {
            if (i > 0 && participants.get(i).score < participants.get(i - 1).score) {
                rank = i + 1;
            }
            System.out.println(rank + " " + participants.get(i).name + " " + participants.get(i).score);
        }
    }
}