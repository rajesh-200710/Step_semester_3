package week_10_problems.assignment_problems;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CancelledOrdersCleanup {
    public static Node removeAll(Node head, int code) {
        while (head != null && head.data == code) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == code) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(5);

        head = removeAll(head, 5);
        printList(head);
    }
}