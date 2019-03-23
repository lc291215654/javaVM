package another4rProblem;

import my.li.org.binary.TreeNode;

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



    static class Solution {

        /**
         * 114. Flatten Binary Tree to Linked List
         * @param root
         */
        public void flatten(TreeNode root) {
            flattenHelper(root,null);
        }

        private TreeNode flattenHelper(TreeNode root,TreeNode prev) {
            TreeNode right = null;
            if(root.right != null){
                right = root.right;
            }
            TreeNode cur = flattenHelper(root,prev);
            cur.right = right;
            return null;
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
