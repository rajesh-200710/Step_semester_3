package week_12_problems.assignment_problems;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LastButKAnnouncement {
    public static String kthFromEnd(Node head, int k) {
        if (head == null || k <= 0) {
            return "Invalid k";
        }

        Node lead = head;
        Node trail = head;

        for (int i = 0; i < k; i++) {
            if (lead == null) {
                return "Invalid k";
            }
            lead = lead.next;
        }

        while (lead != null) {
            lead = lead.next;
            trail = trail.next;
        }

        return k + " from the end: " + trail.data;
    }

    public static void main(String[] args) {
        Node head = new Node(301);
        head.next = new Node(302);
        head.next.next = new Node(303);
        head.next.next.next = new Node(304);
        head.next.next.next.next = new Node(305);
        head.next.next.next.next.next = new Node(306);

        System.out.println(kthFromEnd(head, 2));
        System.out.println(kthFromEnd(head, 5));
    }
}