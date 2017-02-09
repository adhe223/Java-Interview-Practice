package code;

import java.util.ArrayDeque;

public class StackQueue<E> {
    private ArrayDeque<E> on = new ArrayDeque<>(); // Push onto
    private ArrayDeque<E> off = new ArrayDeque<>(); // Pop off of

    public void enqueue(E in) {
        this.on.push(in);
    }

    public E dequeue() {
        if (this.off.size() > 0) {
            return this.off.pop();
        } else {
            this.shuffle();
        }

        if (this.off.size() > 0) {
            return this.off.pop();
        } else {
            return null;
        }
    }

    // Move all elements in on to off
    private void shuffle() {
        while(on.size() > 0) {
            off.push(on.pop());
        }
    }
}