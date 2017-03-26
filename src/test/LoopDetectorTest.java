package test;

import code.Helpers.LinkedListNode;
import code.LinkedList.LoopDetector;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LoopDetectorTest {
    @Test
    public void validate_loop() {
        LoopDetector tester = new LoopDetector();
        LinkedListNode head = new LinkedListNode("1");
        head.next = new LinkedListNode("2");
        head.next.next = new LinkedListNode("3");
        head.next.next.next = new LinkedListNode("4");
        head.next.next.next.next = head;
        assertEquals(4, tester.isLoop(head));
    }
}
