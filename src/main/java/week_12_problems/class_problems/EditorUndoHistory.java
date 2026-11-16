package week_12_problems.class_problems;

import java.util.*;

class Editor {
    private String[] stack;
    private int top;
    private int capacity;

    public Editor(int capacity) {
        this.capacity = capacity;
        this.stack = new String[capacity];
        this.top = -1;
    }

    public void type(String word) {
        if (top == capacity - 1) {
            System.out.println("rejected: history full");
            return;
        }
        stack[++top] = word;
        printHistory();
    }

    public void undo() {
        if (top == -1) {
            System.out.println("rejected: nothing to undo");
            return;
        }
        top--;
        printHistory();
    }

    private void printHistory() {
        if (top == -1) {
            System.out.println("(empty)");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]);
            if (i < top) sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}

public class EditorUndoHistory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;

        String label = sc.next();
        int capacity = label.equalsIgnoreCase("Capacity") ? sc.nextInt() : Integer.parseInt(label);
        Editor editor = new Editor(capacity);

        while (sc.hasNext()) {
            String cmd = sc.next().replace(";", "");
            if (cmd.equalsIgnoreCase("TYPE")) {
                String word = sc.next().replace(";", "");
                editor.type(word);
            } else if (cmd.equalsIgnoreCase("UNDO")) {
                editor.undo();
            }
        }
        sc.close();
    }
}