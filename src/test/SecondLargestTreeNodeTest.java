package test;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

import code.Trees.SecondLargestTreeNode;
import code.Trees.BinaryTreeNode;
import org.junit.rules.ExpectedException;

public class SecondLargestTreeNodeTest {
    BinaryTreeNode goodTreeHead;
    BinaryTreeNode justAHead;
    BinaryTreeNode left2Head;
    BinaryTreeNode left3Head;
    BinaryTreeNode funky;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void initialize() {
        goodTreeHead = new BinaryTreeNode(5);

        BinaryTreeNode left = goodTreeHead.insertLeft(3);
        BinaryTreeNode leftLeft = left.insertLeft(2);
        BinaryTreeNode leftRight = left.insertRight(4);
        BinaryTreeNode leftLeftLeft = leftLeft.insertLeft(1);

        BinaryTreeNode right = goodTreeHead.insertRight(8);
        BinaryTreeNode rightLeft = right.insertLeft(6);
        BinaryTreeNode rightRight = right.insertRight(10);

        justAHead = new BinaryTreeNode(5);

        left2Head = new BinaryTreeNode(5);
        left2Head.insertLeft(2);

        left3Head = new BinaryTreeNode(5);
        left3Head.insertLeft(2).insertLeft(1);

        funky = new BinaryTreeNode(5);
        funky.insertRight(8).insertRight(13).insertLeft(10).insertRight(11);
    }

    @Test
    public void validate_goodTree() {
        SecondLargestTreeNode tester = new SecondLargestTreeNode();

        try {
            assertEquals(8, tester.getSecondLargestValue(this.goodTreeHead));
        } catch (Exception e) {}
    }

    // Should also have a test for an empty tree
    @Test
    public void validate_justAHead() throws Exception {
        SecondLargestTreeNode tester = new SecondLargestTreeNode();

        exception.expect(Exception.class);
        tester.getSecondLargestValue(this.justAHead);
    }

    // And for a tree with 2 values, all left
    @Test
    public void validate_left2() throws Exception {
        SecondLargestTreeNode tester = new SecondLargestTreeNode();

        try {
            assertEquals(5, tester.getSecondLargestValue(this.left2Head));
        } catch (Exception e) {}
    }

    // And a tree with 3 values, all left
    @Test
    public void validate_left3() throws Exception {
        SecondLargestTreeNode tester = new SecondLargestTreeNode();

        try {
            assertEquals(2, tester.getSecondLargestValue(this.left3Head));
        } catch (Exception e) {}
    }

    // Largest value has a left subtree
    @Test
    public void validate_funky() throws Exception {
        SecondLargestTreeNode tester = new SecondLargestTreeNode();

        try {
            assertEquals(11, tester.getSecondLargestValue(this.funky));
        } catch (Exception e) {}
    }
}
