package another4rProblem;

import my.li.org.binary.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Problem5 {

    public static void main(String[] srgs){
        Solution solution = new Solution();
        String re = solution.getHint("1807", "7810");
        System.out.println(re);
    }


    static class Solution {

        public static void main(String[] args){
            Solution solution = new Solution();
            int re = solution.rangeBitwiseAnd(0,2147483647);
            System.out.println(re);
        }

        /**
         * 202. Happy Number
         * @param n
         * @return
         */
        public boolean isHappy(int n) {
            Set<Integer> loop = new HashSet<Integer>();
            while (loop.add(n)){
                n = digitSquareSum(n);
            }
            if(n == 1){
                return true;
            }
            return false;
        }

        int digitSquareSum(int n) {
            int sum = 0, tmp;
            while (n != 0) {
                tmp = n % 10;
                sum += tmp * tmp;
                n /= 10;
            }
            return sum;
        }

        /**
         * 203. Remove Linked List Elements
         * @param head
         * @param val
         * @return
         */
        public ListNode removeElements(ListNode head, int val) {
            if(head == null){
                return head;
            }
            ListNode cur = new ListNode(-1);
            cur.next = head;
            head = cur;
            while (cur.next != null){
                while (cur.next != null && cur.next.val == val){
                    cur.next = cur.next.next;
                }
                cur = cur.next;
            }
            return head.next;
        }


        /**
         * 201. Bitwise AND of Numbers Range
         *
         * @param m
         * @param n
         * @return
         */
        public int rangeBitwiseAnd(int m, int n) {
            if(m == 0){
                return 0;
            }
            for (int i = m; i <= n; i++) {
                m &= i;
            }
            return m;
        }

        /**
         * 204. Count Primes
         *
         * @param n
         * @return
         */
        public int countPrimes(int n) {
            boolean[] isPrime = new boolean[n + 1];
            for (int i = 2; i < n; i++) {
                isPrime[i] = true;
            }
            for (int i = 2; i * i < n; i++) {
                if (isPrime[i]) {
                    for (int j = i + i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime[i]) {
                    count++;
                }
            }
            return count;
        }

        /**
         * 231. Power of Two
         *
         * @param n
         * @return
         */
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) return false;
            return (n & (n - 1)) == 0;
        }

        /**
         * 242. Valid Anagram
         * @param s
         * @param t
         * @return
         */
        public boolean isAnagram(String s, String t) {
            int[] nums = new int[26];
            char[] ss = s.toCharArray();
            for(char c:ss){
                nums[c - 'a']++;
            }
            char[] ts = t.toCharArray();
            if(ss.length != ts.length){
                return false;
            }
            for(char c:ts){
                nums[c - 'a']--;
                if(nums[c - 'a'] < 0){
                    return false;
                }
            }
            return true;
        }


        /**
         * 299. Bulls and Cows
         * @param secret
         * @param guess
         * @return
         */
        public String getHint(String secret, String guess) {
            int bulls = 0;
            int cows = 0;
            int len = secret.length();
            int[] snums = new int[10];
            int[] gnums = new int[10];
            for(int i =0;i<len;i++){
                int s = secret.charAt(i) - '0';
                int g = guess.charAt(i) - '0';
                if(s == g){
                    bulls++;
                }else {
                    if(gnums[s]>0){
                        cows++;
                        gnums[s]--;
                    }else {
                        snums[s]++;
                    }
                    if(snums[g]>0){
                        cows++;
                        snums[g]--;
                    }else {
                        gnums[g]++;
                    }
                }
            }
            return bulls+"A"+cows+"B";

        }

    }
}