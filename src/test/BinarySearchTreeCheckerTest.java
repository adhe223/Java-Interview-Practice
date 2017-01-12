package test;

import code.Trees.BinarySearchTreeChecker;
import code.Trees.BinaryTreeNode;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BinarySearchTreeCheckerTest {
    @Test
    public void validate_bst_true() {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.insertLeft(2);
        root.left.insertLeft(-1);
        root.left.insertRight(4);
        root.insertRight(10);
        root.right.insertLeft(9);
        root.right.left.insertLeft(8);

        BinarySearchTreeChecker tester = new BinarySearchTreeChecker();
        boolean result = tester.isBST(root);
        assertEquals(true, result);
    }

    @Test
    public void validate_bst_false() {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.insertLeft(2);
        root.left.insertLeft(-1);
        root.left.insertRight(4);
        root.insertRight(10);
        root.right.insertLeft(9);
        root.right.left.insertLeft(2);

        BinarySearchTreeChecker tester = new BinarySearchTreeChecker();
        boolean result = tester.isBST(root);
        assertEquals(false, result);
    }
}
