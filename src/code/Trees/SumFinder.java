package code.Trees;

import code.Helpers.LinkedListNode;

import java.util.Stack;

public class SumFinder {
    public String getPair(BinaryTreeNode head, int target) {
        Stack<BinaryTreeNode> s1 = new Stack<>();
        Stack<BinaryTreeNode> s2 = new Stack<>();
        BinaryTreeNode curr1 = head, curr2 = head;
        boolean done1 = false, done2 = false;
        Integer val1 = 0, val2 = 0;

        while (true) {
            // Get next node from inorder traversal
            while (!done1) {
                if (curr1 != null) {
                    s1.push(curr1);
                    curr1 = curr1.left;
                } else {
                    if (s1.isEmpty()) {
                        done1 = true;
                    } else {
                        curr1 = s1.pop();
                        val1 = curr1.value;
                        curr1 = curr1.right;
                        done1 = true;
                    }
                }
            }

            // Get next node from reverse inorder traversal
            while (!done2) {
                if (curr2 != null) {
                    s2.push(curr2);
                    curr2 = curr2.right;
                } else {
                    if (s2.isEmpty()) {
                        done2 = true;
                    } else {
                        curr2 = s2.pop();
                        val2 = curr2.value;
                        curr2 = curr2.left;
                        done2 = true;
                    }
                }
            }

            // Check for pair
            if (!val1.equals(val2) && val1 + val2 == target) {
                return val1.toString() + val2.toString();
            } else if (val1 + val2 < target) {
                // Advance the normal traversal node
                done1 = false;
            } else if (val1 + val2 > target) {
                // Advance the reverse traversal node
                done2 = false;
            }

            // We've gone through all the nodes
            if (val1 >= val2) {
                return "";
            }
        }
    }
}
