package main.java.week_11_problems.class_problems;

public class Problem4_DeleteNthNode {

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
     * Deletes the node at 1-based index n from a singly linked list[cite: 14].
     */
    public static Node deleteNthNode(Node head, int n) {
        if (head == null) {
            return null;
        }

        // Special case: deleting head node (n = 1)[cite: 14]
        if (n == 1) {
            return head.next;
        }

        // Traverse to (n-1)-th node[cite: 14]
        Node current = head;
        for (int i = 1; i < n - 1 && current != null; i++) {
            current = current.next;
        }

        // Bypass the n-th node[cite: 14]
        if (current != null && current.next != null) {
            current.next = current.next.next;
        }

        return head;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? "->" : ""));
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample Input 1: 10->20->30->40, n = 3[cite: 14]
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);

        head1 = deleteNthNode(head1, 3);
        System.out.print("Sample 1 Output: ");
        printList(head1); // Output: 10->20->40[cite: 14]

        // Sample Input 2: 10->20->30->40, n = 1[cite: 14]
        Node head2 = new Node(10);
        head2.next = new Node(20);
        head2.next.next = new Node(30);
        head2.next.next.next = new Node(40);

        head2 = deleteNthNode(head2, 1);
        System.out.print("Sample 2 Output: ");
        printList(head2); // Output: 20->30->40[cite: 14]
    }
}
