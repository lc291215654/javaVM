package my.li.org.stack;

import java.util.Stack;

/**
 * Created by LICHENG on 2017/12/23.
 */
public class Solution {

    public static void main(String args[]) {

        String[] arr = {"0", "3", "/"};

        System.out.println(evalRPN(arr));
//        System.out.println(0/3);

    }

    public static int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<String>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i] == "+"){
                int n = Integer.parseInt(stack.pop());
                int m = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(n+m));
            }else if(tokens[i] == "-"){
                int n = Integer.parseInt(stack.pop());
                int m = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(m-n));
            }else if(tokens[i] == "*"){
                int n = Integer.parseInt(stack.pop());
                int m = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(n*m));
            }else if(tokens[i].equals("/")){
                int n = Integer.parseInt(stack.pop());
                int m = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(m/n));
            }else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
