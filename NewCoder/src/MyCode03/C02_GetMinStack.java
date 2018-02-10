package MyCode03;

import java.util.Stack;

/**
 * Created by licheng on 2/6/18.
 */
public class C02_GetMinStack {
    public static void main(String args[]){
        MyStack1 myStack1 = new MyStack1();
        myStack1.push(5);
        System.out.println(myStack1.getmin());
        myStack1.push(3);
        System.out.println(myStack1.getmin());
        myStack1.push(1);
        System.out.println(myStack1.getmin());
        myStack1.push(2);
        System.out.println(myStack1.getmin());
        myStack1.push(4);
        System.out.println(myStack1.getmin());

        System.out.println("-----------------");

        myStack1.pop();
        System.out.println(myStack1.getmin());
        myStack1.pop();
        System.out.println(myStack1.getmin());

        myStack1.pop();
        System.out.println(myStack1.getmin());

        myStack1.pop();
        System.out.println(myStack1.getmin());
        myStack1.pop();
        System.out.println(myStack1.getmin());





    }

}

class MyStack1{
    private Stack<Integer> valueStack = new Stack<>();
    private Stack<Integer> minStatck = new Stack<>();

    public void push(int newNum) {
        if (minStatck.isEmpty()){
            minStatck.push(newNum);
        }else if(minStatck.peek() >= newNum){
            minStatck.push(newNum);
        }
        valueStack.push(newNum);
    }

    public int pop() {
        if(valueStack.peek() == minStatck.peek()){
            minStatck.pop();
        }
        return valueStack.pop();
    }

    public int getmin() {
        return minStatck.peek();
    }
}
