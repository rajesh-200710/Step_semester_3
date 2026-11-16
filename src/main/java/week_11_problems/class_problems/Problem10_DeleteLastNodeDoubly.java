package main.java.week_11_problems.class_problems;

public class Problem10_DeleteLastNodeDoubly {

    // Doubly Linked List Node Structure Definition
    static class DNode {
        int data;
        DNode prev;
        DNode next;

        DNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    /**
     * Removes the last node from a doubly linked list given only the head pointer[cite: 17].
     */
    public static DNode deleteLastNodeDoubly(DNode head) {
        // Handle empty or single-node list cases[cite: 17]
        if (head == null || head.next == null) {
            return null;
        }

        // Traverse to the last node[cite: 17]
        DNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Detach the last node[cite: 17]
        current.prev.next = null;
        current.prev = null;

        return head;
    }

    public static void printDLL(DNode head) {
        if (head == null) {
            System.out.println("(empty list)");
            return;
        }
        DNode current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " <-> " : ""));
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample Input 1: head = 1 <-> 2 <-> 3[cite: 17]
        DNode head1 = new DNode(1);
        head1.next = new DNode(2);
        head1.next.prev = head1;
        head1.next.next = new DNode(3);
        head1.next.next.prev = head1.next;

        head1 = deleteLastNodeDoubly(head1);
        System.out.print("Sample 1 Output: ");
        printDLL(head1); // Output: 1 <-> 2[cite: 17]

        // Sample Input 2: head = 5[cite: 17]
        DNode head2 = new DNode(5);
        head2 = deleteLastNodeDoubly(head2);
        System.out.print("Sample 2 Output: ");
        printDLL(head2); // Output: (empty list)[cite: 17]
    }
}
