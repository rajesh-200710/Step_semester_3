package week_12_problems.class_problems;

import java.util.*;

public class SecretNoticeShifter {
    public static String shiftNotice(String text, int k) {
        StringBuilder sb = new StringBuilder();
        k = k % 26;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append((char) ((c - 'a' + k) % 26 + 'a'));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ((c - 'A' + k) % 26 + 'A'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String text = sc.nextLine();
            int k = sc.nextInt();
            System.out.println(shiftNotice(text, k));
        }
        sc.close();
    }
}
