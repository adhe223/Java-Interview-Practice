package code.LinkedList;

import code.Helpers.LinkedListNode;

import java.util.HashSet;

public class LinkedListCycle {
    public boolean hasCyleHash(LinkedListNode head) {
        HashSet<LinkedListNode> archive = new HashSet<>();

        while (head != null) {
            if (archive.contains(head)) {
                return true;
            }
            archive.add(head);

            head = head.next;
        }

        return false;
    }

    public boolean hasCycleRunner(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        // Start it up
        if (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}
