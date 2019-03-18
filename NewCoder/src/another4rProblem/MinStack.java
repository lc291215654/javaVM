package another4rProblem;

import java.util.Stack;

/**
 * Created by licheng on 3/8/19.
 */
public class MinStack {
    /** initialize your data structure here. */
    private Stack<Integer> minStack;
    private Stack<Integer> stack;

    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }else if(minStack.peek() >= x){
            minStack.push(x);
        }
    }

    public void pop() {
        int i = stack.pop();
        if(i == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
