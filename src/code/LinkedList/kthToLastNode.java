package code.LinkedList;

import code.Helpers.LinkedListNode;

public class kthToLastNode {
    public LinkedListNode kthToLast(LinkedListNode head, int k) {
        LinkedListNode runner = head;

        // advance the runner
        for (int i = 0; i < k; i++) {
            if (runner.next == null) {
                return null;
            }
            runner = runner.next;
        }

        while (runner != null) {
            runner = runner.next;
            head = head.next;
        }

        // If runner is null, head should be the kth to last node
        return head;
    }
}
