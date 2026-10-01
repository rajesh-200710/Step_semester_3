package main.java.week_8_problems.assignment_problems;

import java.util.*;

public class AssignmentProblem5 {
    public static void main(String[] args) {
        StudentA5 asha = new StudentA5("Asha", "CSE", Arrays.asList(new EmailChannelA5(), new AppChannelA5()));
        StudentA5 ravi = new StudentA5("Ravi", "ECE", Arrays.asList(new SmsChannelA5()));

        NoticeBoardA5 board = new NoticeBoardA5(Arrays.asList(asha, ravi));

        board.postNotice("Lab Closed Tomorrow", Arrays.asList("CSE"));
        board.postNotice("Fee Deadline Extended", Arrays.asList("CSE", "ECE"));
        board.postNotice("Sports Day", new ArrayList<>());
    }
}

interface NotificationChannelA5 {
    void send(String user, String message);
}
class EmailChannelA5 implements NotificationChannelA5 {
    public void send(String user, String message) { System.out.println("[Email -> " + user + "] " + message); }
}
class SmsChannelA5 implements NotificationChannelA5 {
    public void send(String user, String message) { System.out.println("[SMS -> " + user + "] " + message); }
}
class AppChannelA5 implements NotificationChannelA5 {
    public void send(String user, String message) { System.out.println("[App -> " + user + "] " + message); }
}

class StudentA5 {
    String name;
    String department;
    List<NotificationChannelA5> channels;
    public StudentA5(String name, String department, List<NotificationChannelA5> channels) {
        this.name = name;
        this.department = department;
        this.channels = channels;
    }
}

class NoticeBoardA5 {
    List<StudentA5> students;
    public NoticeBoardA5(List<StudentA5> students) { this.students = students; }

    public void postNotice(String title, List<String> targetDepts) {
        if (targetDepts == null || targetDepts.isEmpty()) {
            System.out.println("Cannot post notice: At least one target department is required.");
            return;
        }
        System.out.println("Notice '" + title + "' posted to " + String.join(", ", targetDepts) + ".");
        for (StudentA5 s : students) {
            if (targetDepts.contains(s.department)) {
                for (NotificationChannelA5 ch : s.channels) ch.send(s.name, title);
            }
        }
    }
}
