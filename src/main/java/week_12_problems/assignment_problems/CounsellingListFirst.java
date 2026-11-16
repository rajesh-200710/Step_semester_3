package week_12_problems.assignment_problems;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CounsellingListFirst {
    public static Node partition(Node head, int passMark) {
        Node belowHead = null;
        Node belowTail = null;
        Node restHead = null;
        Node restTail = null;

        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = null;
            if (current.data < passMark) {
                if (belowHead == null) {
                    belowHead = current;
                    belowTail = current;
                } else {
                    belowTail.next = current;
                    belowTail = current;
                }
            } else {
                if (restHead == null) {
                    restHead = current;
                    restTail = current;
                } else {
                    restTail.next = current;
                    restTail = current;
                }
            }
            current = nextNode;
        }

        if (belowHead == null) {
            return restHead;
        }

        belowTail.next = restHead;
        return belowHead;
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
        Node head = new Node(55);
        head.next = new Node(32);
        head.next.next = new Node(78);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(40);
        head.next.next.next.next.next = new Node(35);

        Node partitioned = partition(head, 40);
        printList(partitioned);
    }
}