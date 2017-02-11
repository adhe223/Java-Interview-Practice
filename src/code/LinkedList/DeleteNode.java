package code.LinkedList;

import code.Helpers.LinkedListNode;

public class DeleteNode {
    public void deleteNode(LinkedListNode node) throws Exception {
        if (node.next != null) {
            node.value = node.next.value;
            node.next = node.next.next;
        } else {
            throw new Exception("Can't delete the last node in a linked list!");
        }
    }
}
