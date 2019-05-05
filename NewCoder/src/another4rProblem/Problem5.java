package another4rProblem;

import my.li.org.binary.ListNode;

import java.util.HashSet;
import java.util.Set;

import my.li.org.binary.TreeNode;

import java.util.*;

public class Problem5 {
    public static void main(String[] srgs){
        Solution solution = new Solution();
        String re = solution.getHint("1807", "7810");
        System.out.println(re);
    }


    static class Solution {

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
         * 205. Isomorphic Strings
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isIsomorphic(String s, String t) {
            char[] ss = s.toCharArray();
            char[] ts = t.toCharArray();
            int[] m1 = new int[256];
            int[] m2 = new int[256];
            for (int i = 0; i < ss.length; ++i) {
                if (m1[ss[i]] != m2[ts[i]]) {
                    return false;
                }
                m1[ss[i]] = i + 1;
                m2[ts[i]] = i + 1;
            }
            return true;
        }

        /**
         * 206. Reverse Linked List
         *
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode cur = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return cur;
        }

        /**
         * 207. Course Schedule
         *
         * @param numCourses
         * @param prerequisites
         * @return
         */
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Queue<Integer> queue = new LinkedList<>();
            int[] in = new int[numCourses];
            int[][] matrix = new int[numCourses][numCourses];
            for (int[] edge : prerequisites) {
                in[edge[0]]++;
                matrix[edge[1]][edge[0]] = 1;
            }
            for (int i = 0; i < numCourses; i++) {
                if (in[i] == 0) {
                    queue.offer(i);
                }
            }
            int n = 0;
            while (!queue.isEmpty()) {
                int k = queue.poll();
                n++;
                for (int i = 0; i < numCourses; i++) {
                    if (matrix[k][i] == 1) {
                        if (--in[i] == 0) {
                            queue.offer(i);
                        }
                    }
                }
            }
            return n == numCourses;
        }

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] result = new int[numCourses];
            Queue<Integer> queue = new LinkedList<>();
            int[] in = new int[numCourses];
            int[][] matrix = new int[numCourses][numCourses];
            for (int[] edge : prerequisites) {
                in[edge[0]]++;
                matrix[edge[1]][edge[0]] = 1;
            }
            for (int i = 0; i < numCourses; i++) {
                if (in[i] == 0) {
                    queue.offer(i);
                }
            }
            int n = 0;
            while (!queue.isEmpty()) {
                int k = queue.poll();
                result[n] = k;
                n++;
                for (int i = 0; i < numCourses; i++) {
                    if (matrix[k][i] == 1) {
                        if (--in[i] == 0) {
                            queue.offer(i);
                        }
                    }
                }
            }
            return n == numCourses ? result : new int[0];
        }

        /**
         * 300. Longest Increasing Subsequence
         *
         * @param nums
         * @return
         */
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int len = 0;
            for (int num : nums) {
                int i = Arrays.binarySearch(dp, 0, len, num);
                if (i < 0) {
                    i = -(i + 1);
                }
                dp[i] = num;
                if (i == len) {
                    len++;
                }
            }
            return len;
        }

        public int lengthOfLIS2(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max + 1;
        }

        public int findKthLargest(int[] nums, int k) {
            int low = 0;
            int high = nums.length - 1;
            k = nums.length - k;
            while (low < high) {
                int l = partition(nums, low, high);
                if (l < k) {
                    low = l + 1;
                } else if (l > k) {
                    high = l - 1;
                } else {
                    break;
                }
            }
            return nums[k];
        }

        public int partition(int[] nums, int low, int high) {

            int i = low;
            int j = high + 1;
            while (true) {
                while (i < high && (nums[++i] < nums[low])) ;
                while (j > low && (nums[low] < nums[--j])) ;
                if (i >= j) {
                    break;
                }
                swap(nums, i, j);
            }
            swap(nums, low, j);
            return j;
        }

        public int partition2(int[] nums, int low, int high) {
            Random random = new Random();
            int k = low + random.nextInt(high - low);
            int pivot = nums[k];
            int less = low - 1;
            int more = high + 1;
            while (low < more) {
                if (nums[low] < pivot) {
                    less++;
                    swap(nums, less, low);
                    low++;
                } else if (nums[low] > pivot) {
                    more--;
                    swap(nums, more, low);
                } else {
                    low++;
                }
            }
            return less + 1;
        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        /**
         * 209. Minimum Size Subarray Sum
         *
         * @param s
         * @param nums
         * @return
         */
        public int minSubArrayLen(int s, int[] nums) {
            int left = 0;
            int right = 0;
            int min = Integer.MAX_VALUE;
            int cursum = 0;
            while (right <= nums.length) {
                if (cursum >= s) {
                    min = Math.min(min, right - left);
                    cursum -= nums[left];
                    left++;
                } else if (right < nums.length && cursum < s) {
                    cursum += nums[right];
                    right++;
                } else {
                    break;
                }
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }

        /**
         * 213. House Robber II
         *
         * @param nums
         * @return
         */
        public int rob(int[] nums) {
            return 0;

        }

        /**
         * 217. Contains Duplicate
         *
         * @param nums
         * @return
         */
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> distinct = new HashSet<Integer>();
            for (int num : nums) {
                if (!distinct.add(num)) {
                    return true;
                }
            }
            return false;
        }


        /**
         * 222. Count Complete Tree Nodes
         *
         * @param root
         * @return
         */
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int rightdepth = countRight(root);
            int leftdepth = countLeft(root);
            if (rightdepth == leftdepth) {
                return 1 << leftdepth - 1;
            }
            return countNodes(root.left) + countNodes(root.right) + 1;
        }

        private int countLeft(TreeNode node) {
            int depth = 0;
            while (node != null) {
                depth++;
                node = node.left;
            }
            return depth;
        }

        private int countRight(TreeNode node) {
            int depth = 0;
            while (node != null) {
                depth++;
                node = node.right;
            }
            return depth;
        }

        /**
         * 233. Number of Digit One
         *
         * @param n
         * @return
         */
        public int countDigitOne(int n) {
            if (n <= 0) {
                return 0;
            }
            int res = 0;
            int left = n;
            int remainder = 0;
            int bit = 0;
            while (left != 0) {
                left = left / 10;
                bit++;
            }
            while (bit > 0) {
                left = n / (int) Math.pow(10, bit);
                remainder = n % (int) Math.pow(10, bit - 1);
                int cur = (n / (int) Math.pow(10, bit - 1)) % 10;
                bit--;
                if (cur == 1) {
                    res += left * Math.pow(10, bit);
                    res += (remainder + 1);
                } else if (cur > 1) {
                    res += (left + 1) * Math.pow(10, bit);
                } else {
                    res += left * Math.pow(10, bit);
                }
            }
            return res;
        }


        /**
         * 238. Product of Array Except Self
         *
         * @param nums
         * @return
         */
        public int[] productExceptSelf(int[] nums) {
            int[] res = new int[nums.length];
            res[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                res[i] = res[i - 1] * nums[i - 1];
            }
            int right = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                res[i] = res[i] * right;
                right *= nums[i];
            }
            return res;
        }


        /**
         * 219. Contains Duplicate II
         *
         * @param nums
         * @param k
         * @return
         */
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int left = 0;
            int right = 0;
            Set<Integer> dup = new HashSet<>();
            while (right <= nums.length) {
                if (right - left < k) {
                    if (!dup.add(nums[right])) {
                        return true;
                    }
                    right++;
                } else {
                    dup.remove(nums[left]);
                    left++;
                }
            }
            return false;
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