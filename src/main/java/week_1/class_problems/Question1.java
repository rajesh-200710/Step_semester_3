package week_1.class_problems;

import java.util.Scanner;
import java.util.Random;
public class Question1 {
    public static String playRound(String playerMove, String computerMove) {
        if(playerMove.equalsIgnoreCase(computerMove)) return "Draw";
        if((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }
    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int wins = 0, losses = 0, draws = 0, rounds = 5;
        String[][] history = new String[rounds][3];
        for(int i = 0; i < rounds; i++) {
            String computerMove = moves[random.nextInt(3)];
            String playerMove = moves[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);
            history[i][0] = playerMove;
            history[i][1] = computerMove;
            history[i][2] = result;
            if(result.equals("Player Wins")) wins++;
            else if(result.equals("Computer Wins")) losses++;
            else draws++;
        }
        System.out.println("Round | Player Move | Computer Move | Result");
        for(int i = 0; i < rounds; i++) {
            System.out.println((i+1) + " | " + history[i][0] + " | " + history[i][1] + " | " + history[i][2]);
        }
        double winPercentage = (double) wins / rounds * 100.0;
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPercentage + "%");
    }
}