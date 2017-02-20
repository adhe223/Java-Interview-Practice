package test;

import code.Helpers.LinkedListNode;
import code.LinkedList.ReverseLinkedList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReverseLinkedListTest {
    @Test
    public void validate_even() {
        LinkedListNode head = new LinkedListNode("A");
        head.next = new LinkedListNode("B");
        head.next.next = new LinkedListNode("C");
        head.next.next.next = new LinkedListNode("D");
        ReverseLinkedList tester = new ReverseLinkedList();
        LinkedListNode reversed = tester.reverse(head);

        assertEquals("D", reversed.value);
        assertEquals("C", reversed.next.value);
        assertEquals("B", reversed.next.next.value);
        assertEquals("A", reversed.next.next.next.value);
    }

    @Test
    public void validate_odd() {
        LinkedListNode head = new LinkedListNode("A");
        head.next = new LinkedListNode("B");
        head.next.next = new LinkedListNode("C");
        ReverseLinkedList tester = new ReverseLinkedList();
        LinkedListNode reversed = tester.reverse(head);

        assertEquals("C", reversed.value);
        assertEquals("B", reversed.next.value);
        assertEquals("A", reversed.next.next.value);
    }

    @Test
    public void validate_odd_inplace() {
        LinkedListNode head = new LinkedListNode("A");
        head.next = new LinkedListNode("B");
        head.next.next = new LinkedListNode("C");
        ReverseLinkedList tester = new ReverseLinkedList();
        LinkedListNode reversed = tester.reverseInplace(head);

        assertEquals("C", reversed.value);
        assertEquals("B", reversed.next.value);
        assertEquals("A", reversed.next.next.value);
    }

    @Test
    public void validate_even_inplace() {
        LinkedListNode head = new LinkedListNode("A");
        head.next = new LinkedListNode("B");
        head.next.next = new LinkedListNode("C");
        head.next.next.next = new LinkedListNode("D");
        ReverseLinkedList tester = new ReverseLinkedList();
        LinkedListNode reversed = tester.reverseInplace(head);

        assertEquals("D", reversed.value);
        assertEquals("C", reversed.next.value);
        assertEquals("B", reversed.next.next.value);
        assertEquals("A", reversed.next.next.next.value);
    }
}