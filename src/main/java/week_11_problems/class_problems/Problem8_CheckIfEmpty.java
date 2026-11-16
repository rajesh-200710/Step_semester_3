package main.java.week_11_problems.class_problems;

public class Problem8_CheckIfEmpty {

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
     * Returns true if the list is empty (head is null), false otherwise.
     */
    public static boolean checkIfEmpty(Node head) {
        return head == null;
    }

    public static void main(String[] args) {
        // Sample Input 1: head = null[cite: 16]
        Node head1 = null;
        System.out.println("Sample 1 Output: " + checkIfEmpty(head1)); // Output: true[cite: 16]

        // Sample Input 2: head = 8[cite: 16]
        Node head2 = new Node(8);
        System.out.println("Sample 2 Output: " + checkIfEmpty(head2)); // Output: false[cite: 16]
    }
}

