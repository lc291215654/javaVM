package com.company;


import com.company.Solution.ListNode;

import java.util.*;

public class Solution {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combine(4,3);
        System.out.println();

        System.out.println();
    }


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int j = 1; j <= n; j++) {
            combineHelper(j, n, k, result, new ArrayList<Integer>());
        }
        return result;
    }

    private void combineHelper(int i, int n, int k, List<List<Integer>> result, List<Integer> cur) {
        cur.add(i);
        if (cur.size() == k) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int j = i; j < n; j++) {
            combineHelper(j + 1, n, k, result, cur);
            cur.remove(cur.size() - 1);
        }
    }


        public int calculateMinimumHP ( int[][] dungeon){
            int m = dungeon.length;
            int n = dungeon[0].length;
            int[][] dp = new int[m][n];
            dp[m - 1][n - 1] = Math.max(1, 0);
            for (int i = m - 1; i >= 0; i--) {
                dp[i][n - 1] = 0;
            }
            return 0;
        }

        /**
         * 90. Subsets II
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> subsetsWithDup ( int[] nums){
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            for (int j = 0; j < nums.length; j++) {
                subsetsWithDupHelper(nums, j, result, new ArrayList<Integer>());
            }
            return result;
        }

        private void subsetsWithDupHelper ( int[] candidates, int i, List<List<Integer>>result, List < Integer > cur){
            if (i >= candidates.length) {
                return;
            }
            cur.add(candidates[i]);
            if (i == candidates.length - 1) {
                result.add(new ArrayList<Integer>(cur));
                return;
            }
            for (int j = i; j < candidates.length - 1; j++) {
                subsetsWithDupHelper(candidates, j + 1, result, cur);
                cur.remove(cur.size() - 1);
                if (candidates[j + 1] == candidates[j]) {
                    continue;
                }
            }
        }

        /**
         * 39. Combination Sum
         *
         * @param candidates
         * @param target
         * @return
         */
        public List<List<Integer>> combinationSum ( int[] candidates, int target){
            Arrays.sort(candidates);
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            for (int j = 0; j < candidates.length; j++) {
                combinationSumHelper(candidates, target - candidates[j], j, result, new ArrayList<Integer>());
            }
            return result;
        }

        private void combinationSumHelper ( int[] candidates, int target, int i, List<List<Integer>>
        result, List < Integer > cur){
            cur.add(candidates[i]);
            if (i >= candidates.length || 0 > target) {
                return;
            }
            if (0 == target) {
                result.add(new ArrayList<Integer>(cur));
                return;
            }
            for (int j = i; j < candidates.length; j++) {
                if (candidates[j] > target) {
                    break;
                }
                combinationSumHelper(candidates, target - candidates[j], j, result, cur);
                cur.remove(cur.size() - 1);
            }
        }

        /**
         * 15. 3Sum
         *
         * @param num
         * @return
         */
        public List<List<Integer>> threeSum ( int[] num){
            Arrays.sort(num);
            List<List<Integer>> res = new LinkedList<>();
            for (int i = 0; i < num.length - 2; i++) {
                if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                    int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                    while (lo < hi) {
                        if (num[lo] + num[hi] == sum) {
                            res.add(Arrays.asList(num[i], num[lo], num[hi]));
                            while (lo < hi && num[lo] == num[lo + 1]) lo++;
                            while (lo < hi && num[hi] == num[hi - 1]) hi--;
                            lo++;
                            hi--;
                        } else if (num[lo] + num[hi] < sum) lo++;
                        else hi--;
                    }
                }
            }
            return res;
        }

        /**
         * 41. First Missing Positive
         *
         * @param nums
         * @return
         */
        public int firstMissingPositive ( int[] nums){
            if (nums == null || nums.length == 0) {
                return 1;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= nums.length && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                    i--;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1)
                    return i + 1;
            }
            return nums.length + 1;
        }

        /**
         * 48. Rotate Image
         *
         * @param matrix
         */
        public void rotate ( int[][] matrix){
            int[][] m = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    m[j][matrix.length - 1 - i] = matrix[i][j];
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = m[i][j];
                }
            }
        }


        /**
         * 50. Pow(x, n)
         *
         * @param x
         * @param n
         * @return
         */
        public double myPow ( double x, int n){
            if (x == 0) {
                return 0;
            }
            if (n == 0) {
                return 1;
            }
            if (n == Integer.MIN_VALUE) {
                return myPow(1 / x, -(n + 1)) * (1 / x);
            } else if (n < 0) {
                return myPow(1 / x, -n);
            }
            if (n % 2 == 0) {
                return myPow(x * x, n / 2);
            } else {
                return myPow(x * x, (n - 1) / 2) * x;
            }


        }

        /**
         * 19. Remove Nth Node From End of List
         *
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd (ListNode head,int n){
            ListNode dummy = new ListNode(-1);
            ListNode first = dummy;
            ListNode second = dummy;
            dummy.next = head;
            for (int i = 0; i < n; i++) {
                first = first.next;
            }
            while (first != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
            return dummy.next;
        }


        public String longestCommonPrefix2 (String[]strs){
            if (strs == null || strs.length == 0) return "";

            for (int i = 0; i < strs[0].length(); i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (i == strs[j].length() || strs[j].charAt(i) != c)
                        return strs[0].substring(0, i);
                }
            }
            return strs[0];
        }

        public String longestCommonPrefix (String[]strs){
            StringBuilder result = new StringBuilder();
            if (strs != null && strs.length > 0) {
                Arrays.sort(strs);
                char[] a = strs[0].toCharArray();
                char[] b = strs[strs.length - 1].toCharArray();

                for (int i = 0; i < a.length; i++) {
                    if (b.length > i && b[i] == a[i]) {
                        result.append(b[i]);
                    } else {
                        return result.toString();
                    }
                }
                return result.toString();
            }
            return "";
        }


        public boolean isPalindrome ( int x){
            if (x < 0) {
                return false;
            }
            int pal = 0;
            int val = x;
            int remainder = 0;
            while (val > 0) {
                remainder = val % 10;
                pal = pal * 10 + remainder;
                val = val / 10;
            }
            return pal == x;
        }

//    List<Integer> list2 = jifenduihuan(70,new int[]{11,15,30});
//        System.out.println();


        static List<Integer> list = new ArrayList<Integer>();
        static boolean flag = true;//

        public static List<Integer> jifenduihuan ( int total, int[] prices){
            Arrays.sort(prices);
            fun(total, prices, prices.length - 1);
            Collections.sort(list);
            return list;
        }

        public static void fun ( int total, int[] prices, int index){
            if (index < 0) return;
            if (total == 0) {
                flag = false;
            }
            for (int i = index; i >= 0 && flag; i--) {
                if (total >= prices[index]) {
                    total -= prices[index];
                    list.add(prices[index]);
                    fun(total, prices, index);
                    if (flag) {
                        list.remove(list.size() - 1);
                    }
                } else {
                    fun(total, prices, index - 1);
                    if (flag) {
                        list.remove(list.size() - 1);
                    }
                }
            }
        }

        public List<Integer> jifenduihuan2 ( int total, int[] prices){
            return search(0, total, prices);
        }

        public List<Integer> search ( int index, int total, int[] prices){
            if (index >= prices.length) {
                return null;
            }
            if (total == 0) {
                return list;
            }
            if (total < 0) {
                return null;
            }
//        return Math.min(search(index, total - prices[index], prices) + 1,
//                search(index + 1, total, prices));

            return null;
        }

        public List<Integer> jiguchuanhua ( int totolNum, int countNum){
            List<Integer> list = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<Integer>();
            for (int i = 1; i <= totolNum; i++) {
                queue.add(i);
            }
            int k = countNum;
            while (!queue.isEmpty()) {
                if (k == 1) {
                    list.add(queue.remove());
                    k = countNum;
                } else {
                    k--;
                    queue.add(queue.poll());
                }
            }
            return list;
        }
    }
