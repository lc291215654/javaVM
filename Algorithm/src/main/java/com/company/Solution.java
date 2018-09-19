package com.company;


import java.util.*;

public class Solution {

    public static void main(String args[]){
        Solution solution = new Solution();

        String[] strs = new String[]{"abc","abcd","adf"};
        System.out.println(solution.longestCommonPrefix(strs));

        System.out.println();
    }

    public String longestCommonPrefix(String[] strs) {
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


    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int pal = 0;
        int val = x;
        int remainder = 0;
        while (val > 0){
            remainder = val % 10;
            pal = pal * 10 + remainder;
            val = val / 10;
        }
        return pal ==  x;
    }

//    List<Integer> list2 = jifenduihuan(70,new int[]{11,15,30});
//        System.out.println();



    static List<Integer> list = new ArrayList<Integer>();
    static boolean flag = true;//

    public static List<Integer> jifenduihuan(int total, int[] prices) {
        Arrays.sort(prices);
        fun(total, prices, prices.length - 1);
        Collections.sort(list);
        return list;
    }

    public static void fun(int total, int[] prices, int index) {
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

    public List<Integer> jifenduihuan2(int total, int[] prices) {
        return search(0, total, prices);
    }

    public List<Integer> search(int index, int total, int[] prices) {
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

    public List<Integer> jiguchuanhua(int totolNum, int countNum) {
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
