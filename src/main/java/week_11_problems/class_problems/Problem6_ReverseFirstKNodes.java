package main.java.week_11_problems.class_problems;

public class Problem6_ReverseFirstKNodes {

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
     * Reverses only the first k nodes of a singly linked list[cite: 15].
     */
    public static Node reverseFirstKNodes(Node head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        Node prev = null;
        Node current = head;
        Node next = null;
        int count = 0;

        // Reverse first k nodes[cite: 15]
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Attach original head (now tail of reversed block) to (k+1)-th node[cite: 15]
        head.next = current;

        // prev is the new head[cite: 15]
        return prev;
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
        // Sample Input 1: 1->2->3->4->5, k = 3[cite: 15]
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        head1 = reverseFirstKNodes(head1, 3);
        System.out.print("Sample 1 Output: ");
        printList(head1); // Output: 3->2->1->4->5[cite: 15]

        // Sample Input 2: 1->2->3->4->5, k = 5[cite: 15]
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);

        head2 = reverseFirstKNodes(head2, 5);
        System.out.print("Sample 2 Output: ");
        printList(head2); // Output: 5->4->3->2->1[cite: 15]
    }
}
