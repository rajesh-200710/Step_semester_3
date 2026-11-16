package main.java.week_11_problems.class_problems;

public class Problem9_InsertAtEndCircular {

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
     * Inserts a node at the logical end of a circular singly linked list[cite: 16].
     */
    public static Node insertAtEndCircular(Node head, int value) {
        Node newNode = new Node(value);

        // If list is empty, new node points to itself[cite: 16]
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        // Traverse to current last node (whose next is head)[cite: 16]
        Node current = head;
        while (current.next != head) {
            current = current.next;
        }

        // Update links[cite: 16]
        current.next = newNode;
        newNode.next = head;

        return head;
    }

    public static void printCircular(Node head) {
        if (head == null) {
            System.out.println("(empty)");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + "->");
            current = current.next;
        } while (current != head);
        System.out.println("(back to " + head.data + ")");
    }

    public static void main(String[] args) {
        // Sample Input 1: 1->2->3->(back to 1), value = 4[cite: 16]
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = head1;

        head1 = insertAtEndCircular(head1, 4);
        System.out.print("Sample 1 Output: ");
        printCircular(head1); // Output: 1->2->3->4->(back to 1)[cite: 16]

        // Sample Input 2: head = null, value = 9[cite: 16]
        Node head2 = null;
        head2 = insertAtEndCircular(head2, 9);
        System.out.print("Sample 2 Output: ");
        printCircular(head2); // Output: 9->(back to 9)[cite: 16]
    }
}
