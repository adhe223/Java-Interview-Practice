package test;

import code.Helpers.LinkedListNode;
import code.LinkedList.kthToLastNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class kthToLastNodeTest {
    @Test
    public void validate_normal() {
        kthToLastNode tester = new kthToLastNode();
        LinkedListNode head = new LinkedListNode("1");
        head.next = new LinkedListNode("2");
        head.next.next = new LinkedListNode("3");
        head.next.next.next = new LinkedListNode("4");
        head.next.next.next.next = new LinkedListNode("5");

        assertEquals("4", tester.kthToLast(head, 2).value);
    }
    @Test
    public void validate_null() {
        kthToLastNode tester = new kthToLastNode();
        LinkedListNode head = new LinkedListNode("1");
        head.next = new LinkedListNode("2");
        head.next.next = new LinkedListNode("3");
        head.next.next.next = new LinkedListNode("4");
        head.next.next.next.next = new LinkedListNode("5");

        assertEquals(null, tester.kthToLast(head, 7));
    }
}
