package code.Trees;

import java.util.Stack;

public class SuperbalancedTree {
    private BinaryTreeNode root;
    private Integer maxDepth;

    public SuperbalancedTree(BinaryTreeNode root) {
        this.root = root;
    }

    public boolean isValid() {
        Stack<Tuple<BinaryTreeNode, Integer>> s = new Stack<>();
        s.add(new Tuple(this.root, 0));

        while (s.isEmpty() == false) {
            Tuple<BinaryTreeNode, Integer> t = s.pop();

            if (t.node.right == null && t.node.left == null) {
                // Check if we're not super balanced
                if (this.maxDepth != null && (Math.abs(t.depth - this.maxDepth)) > 1) {
                    return false;
                }

                // Set the max depth
                if (this.maxDepth == null || t.depth > this.maxDepth) {
                    this.maxDepth = t.depth;
                }
            }

            if (t.node.right != null) {
                s.add(new Tuple<BinaryTreeNode, Integer>(t.node.right, t.depth + 1));
            }
            if (t.node.left != null) {
                s.add(new Tuple<BinaryTreeNode, Integer>(t.node.left, t.depth + 1));
            }
        }

        // Traversed the entire tree
        return true;
    }

    private class Tuple<BinaryTreeNode, Integer> {
        BinaryTreeNode node;
        Integer depth;

        Tuple(BinaryTreeNode node, Integer depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
