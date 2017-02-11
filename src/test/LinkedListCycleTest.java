package test;

import code.Helpers.LinkedListNode;
import code.LinkedList.LinkedListCycle;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LinkedListCycleTest {
    private LinkedListCycle tester = new LinkedListCycle();

    @Test
    public void validate_true_odd() {
        LinkedListNode cycleOddHead = new LinkedListNode("A");
        LinkedListNode B = new LinkedListNode("B");
        LinkedListNode C = new LinkedListNode("C");
        LinkedListNode D = new LinkedListNode("D");
        LinkedListNode E = new LinkedListNode("E");
        
        cycleOddHead.next = B;
        cycleOddHead.next.next = C;
        cycleOddHead.next.next.next = D;
        cycleOddHead.next.next.next.next = E;
        cycleOddHead.next.next.next.next.next = B;
        assertEquals(true, tester.hasCycleRunner(cycleOddHead));
    }

    @Test
    public void validate_true_event() {
        LinkedListNode cycleEvenHead = new LinkedListNode("A");
        LinkedListNode B = new LinkedListNode("B");
        LinkedListNode C = new LinkedListNode("C");
        LinkedListNode D = new LinkedListNode("D");
        LinkedListNode E = new LinkedListNode("E");

        cycleEvenHead.next = B;
        cycleEvenHead.next.next = C;
        cycleEvenHead.next.next.next = D;
        cycleEvenHead.next.next.next.next = B;
        
        assertEquals(true, tester.hasCycleRunner(cycleEvenHead));
    }

    @Test
    public void validate_false() {
        LinkedListNode noCycleHead = new LinkedListNode("A");
        LinkedListNode B = new LinkedListNode("B");
        LinkedListNode C = new LinkedListNode("C");
        LinkedListNode D = new LinkedListNode("D");
        LinkedListNode E = new LinkedListNode("E");

        noCycleHead.next = B;
        noCycleHead.next.next = C;

        assertEquals(false, tester.hasCycleRunner(noCycleHead));
    }
}
