package code.Trees;

import code.Trees.BinaryTreeNode;

public class SecondLargestTreeNode {
    public int getSecondLargestValue(BinaryTreeNode head) throws Exception {
        if (head.left == null && head.right == null) {
            throw new Exception("This tree sucks");
        } else if (head.right == null) {
            if (head.left.left == null) {
                // Left left does not exist, the head is the one
                return head.value;
            } else {
                // The second largest is the left child of the head
                return head.left.value;
            }
        }

        BinaryTreeNode secondLargestNode = descend(head, null, false);
        return secondLargestNode.value;
    }

    // Method that goes to the rightmost, then up one. We should never have node.right be undefined here because of
    // checking right.right in this method, and the inital check in the entry function.
    public BinaryTreeNode descend(BinaryTreeNode node, BinaryTreeNode parent, Boolean max) {
        if (node.right != null) {
            return descend(node.right, node, max);
        } else if (node.left != null) {
            // We are at the right most value
            if (max) { return node; }   // We are at the max of this subtree

            // Otherwise, descend the left subtree looking for the max
            return descend(node.left, node, true);
        } else {
            // Left and right are null, that means the parent must be the second largest if we aren't ina  subtree
            if (max) { return node; }
            else { return parent; }
        }
    }
}
