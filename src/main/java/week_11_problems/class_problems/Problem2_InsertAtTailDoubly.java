package main.java.week_11_problems.class_problems;

class DNode {
    int data;
    DNode prev;
    DNode next;

    DNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
public class Problem2_InsertAtTailDoubly {

    /**
     * Inserts a new node at the tail of a doubly linked list given only the head.
     */
    public static DNode insertAtTailDoubly(DNode head, int value) {
        DNode newNode = new DNode(value);

        // If list is empty, new node becomes the head
        if (head == null) {
            return newNode;
        }

        // Traverse to the last node
        DNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Update references
        current.next = newNode;
        newNode.prev = current;

        return head;
    }
}
