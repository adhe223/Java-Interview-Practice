package code.LinkedList;

import code.Helpers.LinkedListNode;

public class LoopDetector {
    public int isLoop(LinkedListNode head) {
        LinkedListNode fast, slow;

        if (head.next == null) {
            return 1;
        }
        fast = head.next.next;
        slow = head.next;

        while (fast != slow) {
            if (fast.next == null) {
                return -1;  // reached the end
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        // To find the start of the cycle, move slow back to the start, and incrememnt each by one. count the steps to find
        // the length of the lead of the list
        int leadSteps = 0;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
            leadSteps++;
        }

        // Slow and fast are now the start of the cycle. Move fast until it is slow, that's the length of the cycle
        int cycleSteps = 1;
        slow = slow.next;
        while (slow != fast) {
            slow = slow.next;
            cycleSteps++;
        }

        return leadSteps + cycleSteps;
    }
}
