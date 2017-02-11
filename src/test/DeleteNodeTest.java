package test;

import code.Helpers.LinkedListNode;
import code.LinkedList.DeleteNode;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DeleteNodeTest {
    @Test
    public void verify_deleted() {
        DeleteNode tester = new DeleteNode();
        LinkedListNode a = new LinkedListNode("A");
        LinkedListNode b = new LinkedListNode("B");
        LinkedListNode c = new LinkedListNode("C");

        a.next = b;
        b.next = c;

        try {
            tester.deleteNode(b);
            assertEquals("C", a.next.value);
        } catch(Exception e) {}
    }
}
