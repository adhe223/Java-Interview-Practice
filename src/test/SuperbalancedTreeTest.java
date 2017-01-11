package test;

import code.Trees.BinaryTreeNode;
import code.Trees.SuperbalancedTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SuperbalancedTreeTest {
    @Test
    public void validate_superbalanced_true() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.insertLeft(2);
        root.insertRight(4);
        root.left.insertLeft(3);
        root.left.insertRight(5);
        root.left.right.insertLeft(6);

        SuperbalancedTree tester = new SuperbalancedTree(root);
        boolean result = tester.isValid();

        assertEquals(false, result);
    }

    @Test
    public void validate_superbalanced_false() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.insertLeft(2);
        root.insertRight(4);
        root.right.insertRight(7);
        root.left.insertLeft(3);
        root.left.insertRight(5);
        root.left.right.insertLeft(6);

        SuperbalancedTree tester = new SuperbalancedTree(root);
        boolean result = tester.isValid();

        assertEquals(true, result);
    }
}
