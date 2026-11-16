package main.java.week_11_problems.class_problems;

public class Problem3_RemoveFirstKNodes {

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
     * Removes the first k nodes from a singly linked list.
     */
    public static Node removeFirstKNodes(Node head, int k) {
        while (head != null && k > 0) {
            head = head.next;
            k--;
        }
        return head;
    }

    // Helper to print SLL
    public static void printList(Node head) {
        if (head == null) {
            System.out.println("(empty list)");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? "->" : ""));
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample Input 1: 1->2->3->4->5, k = 2[cite: 14]
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        head1 = removeFirstKNodes(head1, 2);
        System.out.print("Sample 1 Output: ");
        printList(head1); // Output: 3->4->5[cite: 14]

        // Sample Input 2: 1->2, k = 5[cite: 14]
        Node head2 = new Node(1);
        head2.next = new Node(2);

        head2 = removeFirstKNodes(head2, 5);
        System.out.print("Sample 2 Output: ");
        printList(head2); // Output: (empty list)[cite: 14]
    }
}
