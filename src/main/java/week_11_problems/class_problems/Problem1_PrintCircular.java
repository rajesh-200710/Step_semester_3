package main.java.week_11_problems.class_problems;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class Problem1_PrintCircular {

    /**
     * Prints the data of each node in a circular singly linked list exactly once.
     */
    public static void printCircular(Node head) {
        // Handle empty list case
        if (head == null) {
            System.out.println();
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);

        System.out.println();
    }
}
