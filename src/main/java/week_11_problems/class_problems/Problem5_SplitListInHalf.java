package main.java.week_11_problems.class_problems;

public class Problem5_SplitListInHalf {

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
     * Splits list into two halves using fast & slow pointers.
     * Returns the head of the second half[cite: 14].
     *
     * Complexity:
     * - Time Complexity: O(N)[cite: 15]
     * - Space Complexity: O(1) auxiliary space[cite: 15]
     */
    public static Node splitListInHalf(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        // Advance fast by 2 and slow by 1[cite: 15]
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Head of second half[cite: 15]
        Node secondHalfHead = slow.next;

        // Terminate first half[cite: 15]
        slow.next = null;

        return secondHalfHead;
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
        // Sample Input 1: 1->2->3->4->5[cite: 15]
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        Node second1 = splitListInHalf(head1);
        System.out.print("Sample 1 - First half: ");
        printList(head1);   // Output: 1->2->3[cite: 15]
        System.out.print("Sample 1 - Returned:   ");
        printList(second1); // Output: 4->5[cite: 15]

        // Sample Input 2: 1->2->3->4[cite: 15]
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);

        Node second2 = splitListInHalf(head2);
        System.out.print("Sample 2 - First half: ");
        printList(head2);   // Output: 1->2[cite: 15]
        System.out.print("Sample 2 - Returned:   ");
        printList(second2); // Output: 3->4[cite: 15]
    }
}
