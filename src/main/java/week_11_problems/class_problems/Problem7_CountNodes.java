package main.java.week_11_problems.class_problems;

public class Problem7_CountNodes {

    // Node Structure Definition
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Counts and returns total number of nodes in a singly linked list[cite: 15, 16].
     */
    public static int countNodes(Node head) {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        // Sample Input 1: 5->10->15[cite: 15]
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);

        System.out.println("Sample 1 Output: " + countNodes(head1)); // Output: 3[cite: 15]

        // Sample Input 2: head = null[cite: 15]
        Node head2 = null;
        System.out.println("Sample 2 Output: " + countNodes(head2)); // Output: 0[cite: 15]
    }
}
