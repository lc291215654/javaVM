package another4rProblem;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> pushstack;
    private Stack<Integer> popstack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        pushstack = new Stack<>();
        popstack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        pushstack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (popstack.isEmpty()) {
            exchange();
        }
        return popstack.pop();
    }

    private void exchange() {
        while (!pushstack.isEmpty()) {
            popstack.push(pushstack.pop());
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (popstack.isEmpty()) {
            exchange();
        }
        return popstack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        if (popstack.isEmpty()) {
            exchange();
        }
        return popstack.isEmpty();
    }
}