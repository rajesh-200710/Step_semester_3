package week_12_problems.class_problems;

import java.util.*;

class Timetable {
    private String sectionName;
    private List<String> periods;

    public Timetable(String sectionName, List<String> periods) {
        this.sectionName = sectionName;
        this.periods = new ArrayList<>(periods);
    }

    public Timetable copy(String newSectionName) {
        return new Timetable(newSectionName, new ArrayList<>(this.periods));
    }

    public void setPeriod(int period, String subject) {
        if (period >= 1 && period <= periods.size()) {
            periods.set(period - 1, subject);
        }
    }

    public void print() {
        System.out.println(sectionName + ":");
        System.out.println(periods);
    }
}

public class SectionTimetables {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;

        String line1 = sc.nextLine();
        String[] firstTokens = line1.split(" ");
        String origSection = firstTokens[1];
        int start = line1.indexOf('[');
        int end = line1.indexOf(']');
        String[] subjectArr = line1.substring(start + 1, end).split(",");

        List<String> periods = new ArrayList<>();
        for (String s : subjectArr) {
            periods.add(s.trim());
        }

        Timetable original = new Timetable(origSection, periods);

        String line2 = sc.nextLine();
        String newSection = line2.substring(line2.lastIndexOf(' ') + 1).trim();
        Timetable copy = original.copy(newSection);

        String line3 = sc.nextLine();
        String[] changeTokens = line3.split(" ");
        int periodNum = Integer.parseInt(changeTokens[3]);
        String newSubject = changeTokens[5];
        copy.setPeriod(periodNum, newSubject);

        original.print();
        copy.print();
        sc.close();
    }
