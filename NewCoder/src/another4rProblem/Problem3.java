package another4rProblem;

import my.li.org.binary.ListNode;
import my.li.org.binary.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by licheng on 10/12/18.
 */
public class Problem3 {

    public static void main(String[] args){
        String result = "     osdmap e468: 4 osds: 4 up, 4 in\\n            flags sortbitwise,require_jewel_osds\\n";

        System.out.println(result);
        System.out.println(result.indexOf("osdmap"));
        System.out.println(result.indexOf("\\n"));
        result = result.substring(result.indexOf("osdmap"),result.indexOf("n"));
        System.out.println(result);

    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    static class Solution {

        /**
         * 131. Palindrome Partitioning
         * @param s
         * @return
         */
        public List<List<String>> partition(String s) {
            return null;

        }

        /**
         * 129. Sum Root to Leaf Numbers
         * @param root
         * @return
         */
        public int sumNumbers(TreeNode root) {
            int[] sum = new int[1];
            sumNumbers(root,0,sum);
            return sum[0];
        }

        public void sumNumbers(TreeNode root,int cur, int[] sum) {
            cur = cur * 10 + root.data;
            if(root.left == null && root.right == null){
                sum[0] += cur;
                return;
            }
            if(root.left != null ) sumNumbers(root.left,cur,sum);
            if(root.right != null ) sumNumbers(root.right,cur,sum);
        }

        /**
         * 116. Populating Next Right Pointers in Each Node
         * @param root
         * @return
         */
        public Node connect(Node root) {
            if(root == null ){
                return null;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                int levelnum = queue.size();
                Node pre = queue.poll();
                if(pre.left != null){
                    queue.offer(pre.left);
                }
                if(pre.right != null){
                    queue.offer(pre.right);
                }
                for(int i = 1;i<levelnum;i++){
                    Node cur = queue.poll();
                    pre.next = cur;
                    if(cur.left != null){
                        queue.offer(cur.left);
                    }
                    if(cur.right != null){
                        queue.offer(cur.right);
                    }
                    pre = cur;
                }
            }
            return root;
        }

        /**
         * 142. Linked List Cycle II
         * @param head
         * @return
         */
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) return null;
            ListNode firstp = head;
            ListNode secondp = head;
            boolean isCycle = false;
            while(firstp != null && secondp != null) {
                firstp = firstp.next;
                if (secondp.next == null) return null;
                secondp = secondp.next.next;
                if (firstp == secondp) { isCycle = true; break; }
            }
            if(!isCycle) return null;
            firstp = head;
            while( firstp != secondp) {
                firstp = firstp.next;
                secondp = secondp.next;
            }
            return firstp;
        }

        /**
         * 135. Candy
         * @param ratings
         * @return
         */
        public int candy(int[] ratings) {
            int[] cur = new int[ratings.length];
            cur[0] = 1;
            int result = 0;
            for(int i =0;i<ratings.length - 1; i++){
                if(ratings[i] < ratings[i+1]){
                    cur[i+1] = cur[i] + 1;
                }else{
                    cur[i+1] = 1;
                }
            }
            for(int i= ratings.length -1;i > 0;i--){
                if(ratings[i] < ratings[i-1] && cur[i] >= cur[i-1] ){
                    cur[i-1] =  cur[i] + 1;
                }
            }
            for(int i:cur){
                result += i;
            }
            return result;
        }


        private TreeNode prev = null;
        /**
         * 114. Flatten Binary Tree to Linked List
         * @param root
         */
        public void flatten(TreeNode root) {
            if(root == null){
                return ;
            }
            flatten(root.right) ;
            flatten(root.left);
            root.right = prev;
            root.left = null;
            prev = root;
        }


        /**
         * 115. Distinct Subsequences
         *
         * @param s
         * @param t
         * @return
         */
        public int numDistinct(String s, String t) {
            int[][] dp = new int[t.length()][s.length()];
            char[] ss = s.toCharArray();
            char[] ts = t.toCharArray();
            for (int i = 0; i < ss.length; i++) {
                if (ss[i] == ts[0]) {
                    dp[0][i] = 1;
                }
            }
            for (int i = 1; i < ts.length; i++) {
                for (int j = i; j < ss.length; j++) {
                    if (ss[j] == ts[i]) {
                        dp[i][j] = sum(dp, i - 1, j - 1);
                    }
                }
            }
            return sum(dp, ts.length - 1, ss.length - 1);

        }

        private int sum(int[][] dp, int i, int j) {
            int sum = 0;
            while (j >= 0) {
                sum += dp[i][j];
                j--;
            }
            return sum;
        }


        /**
         * 134. Gas Station
         * @param gas
         * @param cost
         * @return
         */
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int less = 0;
            int start = 0;
            int tank = 0;
            for(int i = 0;i<gas.length ;i++){
                tank = tank + gas[i] - cost[i];
                if(tank < 0 ){
                    start = i + 1;
                    less = less + tank;
                    tank = 0;
                }
            }
            if(tank + less < 0){
                return -1;
            }
            return start;
        }

        /**
         * 150. Evaluate Reverse Polish Notation
         *
         * @param tokens
         * @return
         */
        public int evalRPN(String[] tokens) {
            Stack<String> stack = new Stack<>();
            for (String s : tokens) {
                stack.push(s);
            }
            return evalRPNHelper(stack);
        }

        public int evalRPNHelper(Stack<String> stack) {
            String s = stack.pop();
            if (s.equals("*")) {
                return evalRPNHelper(stack) * evalRPNHelper(stack);
            } else if (s == "+") {
                return evalRPNHelper(stack) + evalRPNHelper(stack);
            } else if (s == "-") {
                int minus = evalRPNHelper(stack);
                return evalRPNHelper(stack) - minus;
            } else if (s == "/") {
                int div = evalRPNHelper(stack);
                return evalRPNHelper(stack) / div;
            } else {
                return Integer.parseInt(s);
            }
        }
    }
}
