package code;

import code.Helpers.MaxStackNode;

import java.util.Stack;

public class MaxStack {
    private Stack<MaxStackNode> stack = new Stack<>();

    public void push(int value) {
        int maxAt;

        if (stack.size() > 0) {
            maxAt = stack.peek().value;
            maxAt = value > maxAt ? value : maxAt;
        } else {
            maxAt = value;
        }

        MaxStackNode node = new MaxStackNode(maxAt, value);
        stack.push(node);
    }

    public Integer pop() {
        if (stack.size() > 0) {
            return stack.pop().value;
        } else {
            return null;
        }
    }

    public Integer peek() {
        if (stack.size() > 0) {
            return stack.peek().value;
        } else {
            return null;
        }
    }

    public Integer getMax() {
        if (stack.size() > 0) {
            return stack.peek().maxAt;
        } else {
            return null;
        }
    }
}
