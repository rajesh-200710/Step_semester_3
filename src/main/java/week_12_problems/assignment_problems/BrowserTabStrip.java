package week_12_problems.assignment_problems;

class TabNode {
    String name;
    TabNode prev;
    TabNode next;

    public TabNode(String name) {
        this.name = name;
    }
}

class Browser {
    private TabNode head;
    private TabNode current;

    public void open(String name) {
        TabNode newNode = new TabNode(name);
        if (head == null) {
            head = newNode;
            current = newNode;
        } else {
            newNode.prev = current;
            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
            current = newNode;
        }
        printState("OPEN " + name);
    }

    public void close() {
        if (current == null) return;
        String closedName = current.name;
        TabNode toClose = current;
        if (toClose.next != null) {
            current = toClose.next;
            current.prev = toClose.prev;
            if (toClose.prev != null) {
                toClose.prev.next = current;
            } else {
                head = current;
            }
        } else if (toClose.prev != null) {
            current = toClose.prev;
            current.next = null;
        } else {
            head = null;
            current = null;
        }
        printState("CLOSE " + closedName);
    }

    public void back() {
        if (current != null && current.prev != null) {
            current = current.prev;
            printState("BACK");
        } else {
            System.out.println("BACK: already at first tab");
        }
    }

    public void forward() {
        if (current != null && current.next != null) {
            current = current.next;
            printState("FORWARD");
        } else {
            System.out.println("FORWARD: already at last tab");
        }
    }

    public void printBackward() {
        System.out.print("Backward: ");
        if (head == null) {
            System.out.println("(empty)");
            return;
        }
        TabNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        TabNode temp = tail;
        while (temp != null) {
            System.out.print(temp.name);
            if (temp.prev != null) {
                System.out.print(" <-> ");
            }
            temp = temp.prev;
        }
        System.out.println();
    }

    private void printState(String action) {
        System.out.print(action + ": ");
        if (head == null) {
            System.out.println("(empty)");
            return;
        }
        TabNode temp = head;
        while (temp != null) {
            if (temp == current) {
                System.out.print("[" + temp.name + "]");
            } else {
                System.out.print(temp.name);
            }
            if (temp.next != null) {
                System.out.print(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}

public class BrowserTabStrip {
    public static void main(String[] args) {
        Browser browser = new Browser();
        browser.open("Mail");
        browser.open("Docs");
        browser.open("Maps");
        browser.back();
        browser.back();
        browser.back();
        browser.open("Drive");
        browser.close();
        browser.forward();
        browser.close();
        browser.printBackward();
    }
}