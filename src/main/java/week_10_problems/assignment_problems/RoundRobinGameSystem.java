package week_10_problems.assignment_problems;

class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    private Node tail;

    public void addLast(String name) {
        Node newNode = new Node(name);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void printTurns(int turns) {
        if (tail == null || turns <= 0) return;
        Node current = tail.next;
        for (int i = 0; i < turns; i++) {
            System.out.print(current.data);
            if (i < turns - 1) {
                System.out.print(" ");
            }
            current = current.next;
        }
        System.out.println();
    }
}

public class RoundRobinGameSystem {
    public static void main(String[] args) {
        CircularLinkedList game = new CircularLinkedList();
        game.addLast("Asha");
        game.addLast("Ravi");
        game.addLast("Neha");

        game.printTurns(7);
    }
}