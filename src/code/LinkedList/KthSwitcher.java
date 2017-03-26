package code.LinkedList;

import code.Helpers.LinkedListNode;
import sun.awt.image.ImageWatched;

public class KthSwitcher {
    public void swap(LinkedListNode head, int k) {
        LinkedListNode kth, runner;
        runner = head;

        for (int i = 1; i < k; i++) {
            if (runner.next == null) {
                return;
            }
            runner = runner.next;
        }
        kth = runner;

        // Adance runner and head until runner is
        while (runner.next != null) {
            runner = runner.next;
            head = head.next;
        }

        // Head is now kthToLast. Swap
        String temp = head.value;
        head.value = kth.value;
        kth.value = temp;
    }
}
