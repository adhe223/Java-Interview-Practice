package test;

import code.Helpers.LinkedListNode;
import code.LinkedList.KthSwitcher;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class KthSwitcherTest {
    @Test
    public void validate_switch() {
        KthSwitcher tester = new KthSwitcher();
        LinkedListNode head = new LinkedListNode("1");
        head.next = new LinkedListNode("2");
        head.next.next = new LinkedListNode("3");
        head.next.next.next = new LinkedListNode("4");
        head.next.next.next.next = new LinkedListNode("5");
        tester.swap(head, 2);

        assertEquals("4", head.next.value);
        assertEquals("2", head.next.next.next.value);
    }
}
