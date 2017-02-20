package code.LinkedList;

import code.Helpers.LinkedListNode;

import java.util.Stack;

public class ReverseLinkedList {
    public LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode original = head;
        LinkedListNode runner = head;
        Stack<String> temp = new Stack<>();

        // Advance runner to the end of the list and push onto stack
        while (runner != null) {
            temp.push(runner.value);
            runner = runner.next;
        }

        // Runenr and head should meet in the middle for an odd number, or pass each other for even
        while (temp.size() > 0) {
            head.value = temp.pop();
            if (head.next != null) {
                head = head.next;
            } else {
                break;
            }
        }

        return original;
    }

    public LinkedListNode reverseInplace(LinkedListNode head) {
        LinkedListNode previous = null;
        LinkedListNode next = null;

        while (head != null) {
            // Store the next node
            next = head.next;

            // Switch
            head.next = previous;
            previous = head;

            // Advance the pointer
            head = next;
        }

        return previous;
    }
}
