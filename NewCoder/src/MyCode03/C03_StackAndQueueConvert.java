package MyCode03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class C03_StackAndQueueConvert {



    public static class TwoQueuesStack {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> help = new LinkedList<>();

        public void push(int pushInt) {
            queue.add(pushInt);
            while (!help.isEmpty()){
                queue.add(help.poll());
            }
            swap();
        }

        public int peek() {
            return help.peek();
        }

        public int pop() {
            return help.poll();
        }

        private void swap() {
            Queue<Integer> tmp = help;
            help = queue;
            queue = tmp;
        }
    }

    public static void main(String[] args){
        TwoQueuesStack twoStacksQueue = new TwoQueuesStack();
        twoStacksQueue.push(5);
        twoStacksQueue.push(4);
        twoStacksQueue.push(3);
        System.out.println(twoStacksQueue.pop());
        System.out.println(twoStacksQueue.pop());
        twoStacksQueue.push(2);
        System.out.println(twoStacksQueue.pop());
        twoStacksQueue.push(1);
        System.out.println(twoStacksQueue.pop());
        System.out.println(twoStacksQueue.pop());
        twoStacksQueue.push(0);

        twoStacksQueue.push(-1);
        System.out.println(twoStacksQueue.peek());
        System.out.println(twoStacksQueue.pop());
        System.out.println(twoStacksQueue.pop());
        System.out.println(twoStacksQueue.pop());
    }




}

class TwoStacksQueue {
    private Stack<Integer> pushStack = new Stack<Integer>();
    private Stack<Integer> popStack = new Stack<Integer>();

    public void push(int pushInt) {
        pushStack.push(pushInt);
    }

    public int poll() {
        if(pushStack.empty() && popStack.empty()){
            throw  new ArrayIndexOutOfBoundsException("The queue is empty");
        }else if(popStack.empty() && !pushStack.empty()){
            while (!pushStack.empty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public int peek() {
        if(pushStack.empty() && popStack.empty()){
            throw  new ArrayIndexOutOfBoundsException("The queue is empty");
        }else if(popStack.empty() && !pushStack.empty()){
            while (!pushStack.empty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }
}
