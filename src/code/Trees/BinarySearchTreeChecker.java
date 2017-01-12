package code.Trees;

import java.util.ArrayList;
import java.util.Stack;

// TODO: Optimize this to store a lowerbound and upperbound on the future values instead of storing all the parent values.
public class BinarySearchTreeChecker {
    public boolean isBST(BinaryTreeNode root) {
        Stack<BTNodeAndParentValues> s = new Stack<>();
        ArrayList<ParentValueAndLocation> parents = new ArrayList<>();
        s.add(new BTNodeAndParentValues(root, parents));

        while(!s.isEmpty()) {
            BTNodeAndParentValues n = s.pop();

            if (n.node.left != null) {
                ArrayList<ParentValueAndLocation> newParents = (ArrayList<ParentValueAndLocation>)n.parentValues.clone();
                newParents.add(new ParentValueAndLocation(n.node.value, true));
                BTNodeAndParentValues newNode = new BTNodeAndParentValues(n.node.left, newParents);
                if (!newNode.isBSTNode()) {
                    return false;
                }

                s.add(newNode);
            }

            if (n.node.right != null) {
                ArrayList<ParentValueAndLocation> newParents = (ArrayList<ParentValueAndLocation>)n.parentValues.clone();
                newParents.add(new ParentValueAndLocation(n.node.value, false));
                BTNodeAndParentValues newNode = new BTNodeAndParentValues(n.node.right, newParents);
                if (!newNode.isBSTNode()) {
                    return false;
                }

                s.add(newNode);
            }
        }

        return true;
    }

    class BTNodeAndParentValues {
        BinaryTreeNode node;
        ArrayList<ParentValueAndLocation> parentValues;

        BTNodeAndParentValues(BinaryTreeNode node, ArrayList<ParentValueAndLocation> parentValues) {
            this.node = node;
            this.parentValues = parentValues;
        }

        boolean isBSTNode() {
            for (int i = 0; i < parentValues.size(); i++) {
                int parentValue = parentValues.get(i).value;
                boolean parentRight = parentValues.get(i).right;

                if (parentRight) {
                    // Right
                    if (parentValue <= this.node.value) {
                        return false;
                    }
                } else {
                    // Left
                    if (parentValue > this.node.value) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    class ParentValueAndLocation {
        Integer value;
        Boolean right;

        ParentValueAndLocation(Integer value, Boolean right) {
            this.value = value;
            this.right = right;
        }
    }
}
