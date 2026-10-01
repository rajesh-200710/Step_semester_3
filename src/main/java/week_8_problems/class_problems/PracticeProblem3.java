package main.java.week_8_problems.class_problems;

import java.util.*;

public class PracticeProblem3 {
    public static void main(String[] args) {
        StudentP3 s1 = new StudentP3("Student 1");
        AttemptP3 attempt = new AttemptP3(s1, "Exam A");

        attempt.recordAnswer("Question 1");
        attempt.recordAnswer("Question 2");
        attempt.submit();
        attempt.recordAnswer("Question 1");
    }
}

class StudentP3 {
    String name;
    public StudentP3(String name) { this.name = name; }
}

class AttemptP3 {
    StudentP3 student;
    String examName;
    boolean isSubmitted = false;

    public AttemptP3(StudentP3 student, String examName) {
        this.student = student;
        this.examName = examName;
        System.out.println(examName + " started by " + student.name + ".");
    }

    public void recordAnswer(String qId) {
        if (isSubmitted) {
            System.out.println("Cannot change answers for a submitted examination.");
            return;
        }
        System.out.println("Answer recorded for " + qId + ".");
    }

    public void submit() {
        isSubmitted = true;
        System.out.println(examName + " submitted by " + student.name + ". Result: Question 1: Correct (5 points), Question 2: Incorrect (0 points). Total score: 5/10.");
    }
}