package another4rProblem;

import my.li.org.binary.ListNode;
import my.li.org.binary.TreeNode;

import java.util.*;

/**
 * Created by licheng on 9/10/18.
 */
public class Problem {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        String re = solution.minWindow("ADOBECODEBANC","ABC");
        System.out.println(re);


    }


    static class Solution {

        /**
         * 239. Sliding Window Maximum
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            return null;

        }

        /**
         * 108. Convert Sorted Array to Binary Search Tree
         * @param nums
         * @return
         */
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBST(nums,0,nums.length-1);
        }

        public TreeNode sortedArrayToBST(int[] nums,int left,int right) {
            if(left < right){
                return null;
            }else if(left == right){
                return new TreeNode(nums[left]);
            }
            int mid = (right - left) / 2 + left;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBST(nums,left,mid-1);
            root.right = sortedArrayToBST(nums,mid + 1,right);
            return root;
        }



        /**
         * 76. Minimum Window Substring
         * @param s
         * @param t
         * @return
         */
        public String minWindow(String s, String t) {
            int[] map = new int[128];
            for(char c:t.toCharArray()){
                map[c]++;
            }
            int counter = t.length();
            int begin = 0;
            int end = 0;
            int d = Integer.MAX_VALUE;
            int head = 0;
            while (end < s.length()){
                if(map[s.charAt(end)]>0){
                    counter--;
                }
                map[s.charAt(end)]--;
                end++;
                while (counter == 0){
                    if(end-begin < d){
                        d = end - begin;
                        head = begin;
                    }
                    if(map[s.charAt(begin)] == 0){
                        counter++;
                    }
                    map[s.charAt(begin)]++;
                    begin++;
                }
            }
            return d==Integer.MAX_VALUE ? "" : s.substring(head,head + d);
        }

        /**
         * 75. Sort Colors
         * @param nums
         */
        public void sortColors(int[] nums) {
                int n = nums.length;
                int second=n-1, zero=0;
                for (int i=0; i<=second; i++) {
                    while (nums[i]==2 && i<second) swap(nums,i, second--);
                    while (nums[i]==0 && i>zero) swap(nums,i, zero++);
                }
        }

        /**
         * 73. Set Matrix Zeroes
         *
         * @param matrix
         */
        public void setZeroes(int[][] matrix) {
            int col0 = 1, rows = matrix.length, cols = matrix[0].length;

            for (int i = 0; i < rows; i++) {
                if (matrix[i][0] == 0) col0 = 0;
                for (int j = 1; j < cols; j++) {
                    if (matrix[i][j] == 0)
                        matrix[i][0] = matrix[0][j] = 0;
                }
            }
            for (int i = rows - 1; i >= 0; i--) {
                for (int j = cols - 1; j >= 1; j--) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0)
                        matrix[i][j] = 0;
                }
                if (col0 == 0) matrix[i][0] = 0;
            }
        }

        public void setZeroes2(int[][] matrix) {
            int col0 = 1, rows = matrix.length, cols = matrix[0].length;

            for (int i = 0; i < rows; i++) {
                if (matrix[i][0] == 0) col0 = 0;
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] == 0)
                        matrix[i][0] = matrix[0][j] = 0;
                }
            }
            for (int i = rows - 1; i >= 0; i--) {
                for (int j = cols - 1; j >= 0; j--) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0)
                        matrix[i][j] = 0;
                }
//                if (col0 == 0) matrix[i][0] = 0;
            }
        }

        /**
         * 96. Unique Binary Search Trees
         *
         * @param n
         * @return
         */
        public int numTrees(int n) {
            if (n == 0 || n == 1) {
                return n;
            }
            int dp[] = new int[n + 1];
            dp[0] = dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = 0;
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];

        }

        /**
         * 509. Fibonacci Number
         *
         * @param N
         * @return
         */
        public int fib(int N) {
            if (N == 0) {
                return 0;
            }
            int[] dp = new int[N + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[N];
        }

        /**
         * 90. Subsets II
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int len = nums.length;
            Arrays.sort(nums);
            res.add(new ArrayList<>());
            for (int i = 0; i < nums.length; ) {
                int count = 0;
                while (count + i < len && nums[count + i] == nums[i]) {
                    count++;
                }
                int preN = res.size();
                for (int k = 0; k < preN; k++) {
                    List<Integer> instance = new ArrayList<>(res.get(k));
                    for (int j = 0; j < count; j++) {
                        instance.add(nums[i]);
                        res.add(instance);
                        instance = new ArrayList<>(instance);
                    }
                }
                i += count;
            }
            return res;
        }


        /**
         * 32. Longest Valid Parentheses
         *
         * @param s
         * @return
         */
        public int longestValidParentheses(String s) {
            if (s.equals("")) {
                return 0;
            }
            char[] pars = s.toCharArray();
            Stack<Integer> stack = new Stack<>();
            int i = 0;
            stack.push(-1);
            int maxvalid = 0;
            while (i < pars.length) {
                if (pars[i] == '(') {
                    stack.push(i);
                    i++;
                } else {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        int curvalid = i - stack.peek();
                        maxvalid = Math.max(maxvalid, curvalid);
                        i++;
                    } else {
                        stack.push(i);
                        i++;
                    }
                }
            }
            return maxvalid;

        }

        /**
         * 32. Longest Valid Parentheses
         *
         * @param s
         * @return
         */
        public int longestValidParentheses2(String s) {
            if (s.equals("")) {
                return 0;
            }
            int[] dp = new int[s.length() + 1];
            char[] chs = s.toCharArray();
            int res = 0;
            dp[0] = -1;
            for (int i = 1; i < dp.length; i++) {
                if (chs[i - 1] == '(') {
                    dp[i] = i;
                } else {
                    res = Math.max(dp[i], res);
                }
            }
            return 0;
        }

        /**
         * 18. 4Sum
         *
         * @param nums
         * @param target
         * @return
         */
        public List<List<Integer>> fourSum(int[] nums, int target) {
            return null;
        }

        /**
         * 80. Remove Duplicates from Sorted Array II
         *
         * @param nums
         * @return
         */
        public int removeDuplicates2(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int cur = nums[0];
            int time = 1;
            int re = 1;
            for (int i = 1; i < nums.length; i++) {
                if (cur == nums[i]) {
                    time++;
                    if (time <= 2) {
                        re++;
                    }
                } else {
                    cur = nums[i];
                    time = 1;
                    re++;
                }
                nums[re - 1] = nums[i];
            }
            return re;
        }

        /**
         * 98. Validate Binary Search Tree
         *
         * @param root
         * @return
         */
        public boolean isValidBST(TreeNode root) {
            return false;

        }

        public boolean traver(TreeNode root, int pre) {
            if (root == null) {
                return true;
            }
            return false;
        }

        /**
         * 70. Climbing Stairs
         *
         * @param n
         * @return
         */
        public int climbStairs(int n) {
            int[] dp = new int[n];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n - 1];
        }

        /**
         * 67. Add Binary
         *
         * @param a
         * @param b
         * @return
         */
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int i = a.length() - 1, j = b.length() - 1, carry = 0;
            while (i >= 0 || j >= 0) {
                int sum = carry;
                if (j >= 0) sum += b.charAt(j--) - '0';
                if (i >= 0) sum += a.charAt(i--) - '0';
                sb.append(sum % 2);
                carry = sum / 2;
            }
            if (carry != 0) sb.append(carry);
            return sb.reverse().toString();
        }

        /**
         * 66. Plus One
         *
         * @param digits
         * @return
         */
        public int[] plusOne(int[] digits) {
            int len = digits.length;
            for (int i = len - 1; i >= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                    continue;
                } else {
                    digits[i] += 1;
                    return digits;
                }
            }
            int[] re = new int[len + 1];
            re[0] = 1;
            return re;
        }


        /**
         * 65. Valid Number
         *
         * @param s
         * @return
         */
        public boolean isNumber(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }
            s = s.trim();
            if (s.length() == 0) {
                return false;
            }
            if (s.charAt(0) == '+' || s.charAt(0) == '-') {
                s = s.substring(1);
            }
            int len = s.length();
            if (s.contains("e")) {
                return len > s.indexOf('e') + 1 && isBase(s.substring(0, s.indexOf('e')), false) && isP(s.substring(s.indexOf('e') + 1));
            } else {
                return isBase(s, false);
            }
        }

        public boolean isBase(String s, boolean hasNum) {
            if (s == null || s.length() == 0) {
                return false;
            }
            char ch = s.charAt(0);
            if (Character.isDigit(ch)) {
                return s.length() == 1 || isBase(s.substring(1), true);
            }
            if (ch == '.') {
                return s.length() == 1 && hasNum || isnum(s.substring(1));
            }
            return false;
        }

        private boolean isP(String s) {
            char ch = s.charAt(0);
            if (ch == '+' || ch == '-') {
                return isnum(s.substring(1));
            }
            return isnum(s);
        }

        private boolean isnum(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }
            for (char ch : s.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 91. Decode Ways
         *
         * @param s
         * @return
         */
        public int numDecodings(String s) {
            int n = s.length();
            if (n == 0) {
                return 0;
            }
            int[] dp = new int[n + 1];
            dp[n] = 1;
            dp[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;
            for (int i = n - 2; i >= 0; i--) {
                if (s.charAt(i) == '0') {
                    continue;
                } else {
                    dp[i] = Integer.parseInt(s.substring(i, i + 2)) <= 26 ? dp[i + 1] + dp[i + 2] :
                            dp[i + 1];
                }
            }
            return dp[0];
        }

        /**
         * 99. Recover Binary Search Tree
         *
         * @param root
         */
        public void recoverTree(TreeNode root) {
            TreeNode first = null;
            TreeNode second = null;
            TreeNode pre = new TreeNode(Integer.MIN_VALUE);
            traverse(root, first, pre, second);
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
        }

        private void traverse(TreeNode root, TreeNode first, TreeNode pre, TreeNode second) {
            if (root == null) {
                return;
            }
            traverse(root.left, first, pre, second);
            if (first == null && pre.data >= root.data) {
                first = pre;
            }
            if (first == null && pre.data >= root.data) {
                second = root;
            }
            pre = root;
            traverse(root.right, first, pre, second);
        }

        /**
         * 100. Same Tree
         *
         * @param p
         * @param q
         * @return
         */
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p != null & q != null && p.data == q.data && isSameTree(p.left, q.left)
                    && isSameTree(p.right, q.right)) {
                return true;
            }
            return false;
        }

        /**
         * 34. Find First and Last Position of Element in Sorted Array
         *
         * @param nums
         * @param target
         * @return
         */
        public int[] searchRange(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target) {
                    low = mid;
                    high = mid;
                    break;
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }
            if (low > high) {
                return new int[]{-1, -1};
            }
            while (low > 0 && nums[low - 1] == target) {
                low--;
            }
            while (high < nums.length - 1 && nums[high + 1] == target) {
                high++;
            }
            return new int[]{low, high};
        }

        /**
         * 49. Group Anagrams
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) return new ArrayList();
            Map<String, List> ans = new HashMap<String, List>();
            int[] count = new int[26];
            for (String s : strs) {
                Arrays.fill(count, 0);
                for (char c : s.toCharArray()) count[c - 'a']++;

                StringBuilder sb = new StringBuilder("");
                for (int i = 0; i < 26; i++) {
//                    sb.append('#');
                    sb.append(count[i]);
                }
                String key = sb.toString();
                if (!ans.containsKey(key)) ans.put(key, new ArrayList());
                ans.get(key).add(s);
            }
            return new ArrayList(ans.values());
        }

        /**
         * 204. Count Primes
         * @param n
         * @return
         */
        public int countPrimes(int n) {
            boolean[] isPrime = new boolean[n + 1];
            for(int i=2;i<n;i++){
                isPrime[i] = true;
            }
            for(int i = 2;i*i < n;i++){
                if(isPrime[i]){
                    for(int j = i + i;j<n;j+=i){
                        isPrime[j] = false;
                    }
                }
            }
            int count = 0;
            for(int i=2;i< n;i++){
                if(isPrime[i]){
                    count++;
                }
            }
            return count;
        }

        /**
         * 69. Sqrt(x)
         *
         * @param x
         * @return
         */
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }
            int left = 1;
            int right = x / 2 ;
            int mid = (right + left) / 2;
            while (left < right){
                if(mid <= x / mid && (mid+1) > (x / (mid+1))){
                    return mid;
                }
                if(mid  > x / mid){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
                mid = (right + left) / 2;
            }
            return left;
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
         * 470. Implement Rand10() Using Rand7()
         *
         * @return
         */
        public int rand10() {
            int raw, col, idx;
            do {
                raw = rand7();
                col = rand7();
                idx = col + (raw - 1) * 7;
            } while (idx > 40);
            return idx % 10 + 1;
        }

        private int rand7() {
            Random random = new Random();
            return random.nextInt(7);
        }

        /**
         * 29. Divide Two Integers
         *
         * @param dividend
         * @param divisor
         * @return
         */
        public int divide(int dividend, int divisor) {
            if (divisor == 0) {
                return 0;
            }
            int flag = 1;
            if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
                flag = -1;
            }
            long ldividend = Math.abs((long) dividend);
            long ldivisor = Math.abs((long) divisor);
            long tot = 0;
            long p = 1;
            long q = ldivisor;
            while (ldividend >= ldivisor) {
                if (ldividend >= q) {
                    tot = tot + p;
                    ldividend = ldividend - q;
                }
                if (ldividend >= q) {
                    p <<= 1;
                    q <<= 1;
                } else {
                    p >>= 1;
                    q >>= 1;
                }
            }
            return (int) Math.min(Math.max(-2147483648l, tot * flag), 2147483647l);
        }

        /**
         * 47. Permutations II
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> permuteUnique(int[] nums) {

            return null;

        }


        /**
         * 46. Permutations
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            permute(nums, 0, list);
            return list;
        }

        private void permute(int[] nums, int k, List<List<Integer>> list) {
            if (k == nums.length) {
                List<Integer> cur = new ArrayList<>(nums.length);
                for (int i = 0; i < nums.length; i++) {
                    cur.add(nums[i]);
                }
                list.add(cur);
            }
            Set<Integer> set = new HashSet<>();
            for (int i = k; i < nums.length; i++) {
                if (!set.contains(nums[i])) {
                    set.add(nums[i]);
                    swap(nums, k, i);
                    permute(nums, k + 1, list);
                    swap(nums, k, i);
                }
            }
        }

        /**
         * 36. Valid Sudoku
         *
         * @param board
         * @return
         */
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                Set<Character> set = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        if (set.contains(board[i][j])) {
                            return false;
                        }
                        set.add(board[i][j]);
                    }
                }
            }

            for (int i = 0; i < 9; i++) {
                Set<Character> set = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    if (board[j][i] != '.') {
                        if (set.contains(board[j][i])) {
                            return false;
                        }
                        set.add(board[j][i]);
                    }
                }
            }

            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    Set<Character> set = new HashSet<>();
                    for (int m = i; m < i + 3; m++) {
                        for (int n = j; n < j + 3; n++) {
                            if (board[m][n] != '.') {
                                if (set.contains(board[m][n])) {
                                    return false;
                                }
                                System.out.println(m + "  ++  " + n);
                                set.add(board[m][n]);
                            }
                        }
                    }
                }
            }
            return true;
        }

        /**
         * 35. Search Insert Position
         *
         * @param nums
         * @param target
         * @return
         */

        public int searchInsert(int[] nums, int target) {
            if (target > nums[nums.length - 1]) {
                return nums.length;
            }
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = ((high - low) / 2 + low);
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (target > nums[low]) {
                return low + 1;
            } else {
                return low;
            }
        }

        /**
         * 25. Reverse Nodes in k-Group
         *
         * @param head
         * @param k
         * @return
         */
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode curr = head;
            int count = 0;
            while (curr != null && count != k) {
                curr = curr.next;
                count++;
            }
            if (count == k) {
                curr = reverseKGroup(curr, k);
                while (count-- > 0) {
                    ListNode pre = head.next;
                    head.next = curr;
                    curr = head;
                    head = pre;
                }
                head = curr;
            }
            return head;
        }

        /**
         * 37. Sudoku Solver
         *
         * @param board
         */
        public void solveSudoku(char[][] board) {
            solveSudoku(board, 0);
        }

        public boolean solveSudoku(char[][] board, int index) {
            if (index == 81) {
                return true;
            }
            int row = index / 9;
            int col = index % 9;
            if (board[row][col] == '.') {
                for (int i = 1; i <= 9; i++) {
                    board[row][col] = (char) (i + '0');
                    if (check(board, index))
                        if (solveSudoku(board, index + 1))
                            return true;
                    board[row][col] = '.';
                }
            } else {
                if (solveSudoku(board, index + 1))
                    return true;
            }
            return false;
        }

        boolean check(char[][] board, int position) {
            int row = position / 9;
            int col = position % 9;
            int gid;
            if (row >= 0 && row <= 2) {
                if (col >= 0 && col <= 2)
                    gid = 0;
                else if (col >= 3 && col <= 5)
                    gid = 1;
                else
                    gid = 2;
            } else if (row >= 3 && row <= 5) {
                if (col >= 0 && col <= 2)
                    gid = 3;
                else if (col >= 3 && col <= 5)
                    gid = 4;
                else
                    gid = 5;
            } else {
                if (col >= 0 && col <= 2)
                    gid = 6;
                else if (col >= 3 && col <= 5)
                    gid = 7;
                else
                    gid = 8;
            }

            for (int i = 0; i < 9; i++) {
                if (i != col && board[row][i] == board[row][col])
                    return false;
                if (i != row && board[i][col] == board[row][col])
                    return false;
                int r = gid / 3 * 3 + i / 3;
                int c = gid % 3 * 3 + i % 3;
                if ((r != row || c != col) && board[r][c] == board[row][col])
                    return false;
            }
            return true;
        }

        /**
         * 30. Substring with Concatenation of All Words
         *
         * @param s
         * @param words
         * @return
         */
        public List<Integer> findSubstring(String s, String[] words) {
            Map<String, Integer> counts = new HashMap<>();
            for (String word : words) {
                counts.put(word, 1);
            }
            List<Integer> indexes = new ArrayList<>();
            int n = s.length();
            int num = words.length;
            int len = words[0].length();
            for (int i = 0; i <= n - num * len; i++) {
                Map<String, Integer> seen = new HashMap<>();
                int j = 0;
                while (j < num) {
                    String word = s.substring(i + j * len, i + (j + 1) * len);
                    if (counts.containsKey(word)) {
                        if (seen.containsKey(word)) {
                            break;
                        }
                        seen.put(word, 1);
                    } else {
                        break;
                    }
                    j++;
                }
                if (j == num) {
                    indexes.add(i);
                }
            }
            return indexes;
        }

        public int trap(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int result = 0;
            int maxleft = 0, maxright = 0;
            while (left < right) {
                if (height[left] < height[right]) {
                    if (height[left] >= maxleft) {
                        maxleft = height[left];
                    } else {
                        result += maxleft - height[left];
                    }
                    left++;
                } else {
                    if (height[right] >= maxright) {
                        maxright = height[right];
                    } else {
                        result += maxright - height[right];
                    }
                    right--;
                }
            }
            return result;
        }

        /**
         * 23. Merge k Sorted Lists
         *
         * @param lists
         * @return
         */
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode result = new ListNode(-1);
            ListNode cur = result;
            int k = 0;
            int minnum = Integer.MAX_VALUE;
            while (!isEmpty(lists)) {
                for (int i = 0; i < lists.length; i++) {
                    if (lists[i] != null) {
                        if (lists[i].val < minnum) {
                            minnum = lists[i].val;
                            k = i;
                        }
                    }
                }
                cur.next = lists[k];
                cur = cur.next;
                lists[k] = lists[k].next;
                minnum = Integer.MAX_VALUE;
            }
            return result.next;
        }

        private boolean isEmpty(ListNode[] lists) {
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 23. Merge k Sorted Lists
         *
         * @param lists
         * @return
         */
        public ListNode mergeKList2s(ListNode[] lists) {
            return null;

        }


        /**
         * @param head
         * @return
         */
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode cur = head;
            ListNode pre;
            ListNode last = new ListNode(-1);
            head = head.next;
            while (cur != null && cur.next != null) {
                pre = cur.next;
                last.next = pre;
                last = cur;
                cur.next = pre.next;
                pre.next = cur;
                cur = cur.next;
            }
            return head;
        }

        /**
         * 17. Letter Combinations of a Phone Number
         *
         * @param digits
         * @return
         */

        public List<String> letterCombinations(String digits) {
            if (digits.equals("")) {
                return new ArrayList<String>();
            }

            String[] table = new String[]{"abc",
                    "def", "ghi",
                    "jkl", "mno",
                    "pqrs", "tuv",
                    "wxyz"};
            char[] chars = digits.toCharArray();
            List<String> list = new ArrayList<>();

            letterHelper(list, chars, "", table, 0);
            return list;
        }

        public void letterHelper(List<String> list, char[] chars, String cur, String[] table, int n) {
            if (n == chars.length) {
                list.add(cur.trim());
                return;
            }
            String str = table[chars[n] - '2'];
            for (int i = 0; i < str.length(); i++) {
                letterHelper(list, chars, cur + str.charAt(i), table, n + 1);
            }
        }

        /**
         * 10. Regular Expression Matching
         *
         * @param s
         * @param p
         * @return
         */
        public boolean isMatch(String s, String p) {
            if (p.isEmpty()) {
                return s.isEmpty();
            }
            boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
            if (p.length() >= 2 && p.charAt(1) == '*') {
                return (isMatch(s, p.substring(2)) ||
                        (first_match && isMatch(s.substring(1), p)));
            } else {
                return first_match && isMatch(s.substring(1), p.substring(1));
            }
        }

        public boolean isMatch3(String s, String p) {
            if (s == null || p == null) {
                return false;
            }
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == '*' && dp[0][i - 1]) {
                    dp[0][i + 1] = true;
                }
            }
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < p.length(); j++) {
                    if (p.charAt(j) == '.') {
                        dp[i + 1][j + 1] = dp[i][j];
                    }
                    if (p.charAt(j) == s.charAt(i)) {
                        dp[i + 1][j + 1] = dp[i][j];
                    }
                    if (p.charAt(j) == '*') {
                        if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        } else {
                            dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                        }
                    }
                }
            }
            return dp[s.length()][p.length()];
        }

        /**
         * 38. Count and Say
         *
         * @param n
         * @return
         */
        public String countAndSay3(int n) {
            if (n <= 0) return "";
            StringBuilder sb = new StringBuilder();
            String s = "1";

            while (n > 1) {
                int count = 1;
                char lastChar = s.charAt(0);
                for (int i = 1; i < s.length(); i++) {
                    if (s.charAt(i) == lastChar) count++;
                    else {
                        sb.append(count).append(lastChar);
                        count = 1;
                        lastChar = s.charAt(i);
                    }
                }
                sb.append(count).append(lastChar);
                s = sb.toString();
                sb.setLength(0);
                n--;
            }
            return s;
        }

        /**
         * 22. Generate Parentheses
         *
         * @param n
         * @return
         */
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            genHelper(list, "(", 1, 0, n);
            return list;
        }

        public void genHelper(List<String> list, String str, int left, int right, int n) {
            if (right > left || left > n) {
                return;
            }
            if (right == n) {
                list.add(str);
            }
            genHelper(list, str + "(", left + 1, right, n);
            genHelper(list, str + ")", left, right + 1, n);
        }

        /**
         * 26. Remove Duplicates from Sorted Array
         *
         * @param nums
         * @return
         */
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int len = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[len]) {
                    continue;
                }
                len++;
                nums[len] = nums[i];
            }
            return len + 1;
        }

        /**
         * 15. 3Sum
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 3) {
                return res;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int sum = -nums[i];
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        ArrayList<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[left]);
                        triplet.add(nums[right]);
                        res.add(triplet);
                        while (left < right && nums[left++] == nums[left]) {
                        }
                        while (left < right && nums[right--] == nums[right]) {
                        }
                    } else if (nums[left] + nums[right] < sum) {
                        while (left < right && nums[left++] == nums[left]) {
                        }
                    } else {
                        while (left < right && nums[right--] == nums[right]) {
                        }
                    }
                }
            }
            return res;

        }

        public List<List<Integer>> threeSum2(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new LinkedList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
            return res;
        }

        public List<List<Integer>> threeSum3(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new LinkedList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
            return res;
        }

        /**
         * 16. 3Sum Closest
         *
         * @param nums
         * @param target
         * @return
         */
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int res = 0;
            int m = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 2; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int low = i + 1;
                int high = nums.length - 1;
                int sum = target - nums[i];
                while (low < high) {
                    int q = sum - (nums[low] + nums[high]);
                    if (q == 0) {
                        return target;
                    } else if (q < 0) {
                        if (Math.abs(q) < m) {
                            m = Math.abs(q);
                            res = target - q;
                        }
                        high--;
                    } else {
                        if (Math.abs(q) < m) {
                            m = Math.abs(q);
                            res = q;
                        }
                        low++;
                    }
                }
            }
            return res;
        }

        /**
         * 4. Median of Two Sorted Arrays
         *
         * @param A
         * @param B
         * @return
         */
        public double findMedianSortedArrays2(int[] A, int[] B) {
            int m = A.length;
            int n = B.length;
            if (m > n) {
                int[] temp = A;
                A = B;
                B = temp;
                int tmp = m;
                m = n;
                n = tmp;
            }
            if (m == 0) {
                return n % 2 == 0 ? (double) ((B[n / 2] + B[n / 2 - 1])) / 2 : B[n / 2];
            }
            int imin = 0, imax = m, half = (n + m - 1) / 2;
            while (imin <= imax) {
                int i = (imin + imax) / 2; //
                int t = half - i;
                if (i > imin && A[i - 1] > B[t]) {
                    imax = i - 1;
                } else if (t > 0 && A[i] < B[t - 1]) {
                    imin = i + 1;
                } else {
                    if (i == 0) {
                        if ((m + n) % 2 == 0) {
                            return (double) (B[half] + B[half + 1]) / 2;
                        } else {
                            return B[half];
                        }
                    }
                    if (i == m) {
                        if ((m + n) % 2 == 0) {
                            return (double) (B[half - imin] + B[half - imin + 1]) / 2;
                        } else {
                            return B[half - imin];
                        }
                    }
                    if ((m + n) % 2 == 0) {
                        return (double) (A[i] + B[half - i]) / 2;
                    } else {
                        return Math.min(A[i], B[half - i]);
                    }
                }
            }
            return 0.0;
        }

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            if (m > n) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
                int tmp = m;
                m = n;
                n = tmp;
            }
            if (m == 0) {
                return n % 2 == 0 ? (double) ((nums2[n / 2] + nums2[n / 2 - 1])) / 2 : nums2[n / 2];
            }
            int mmin = 0, mmax = m - 1;
            int half = (m + n) / 2;
            while (mmin <= mmax) {
                int mmid = (mmin + mmax) / 2;
                if (mmid == 0 && nums1[0] >= nums2[n - 1]) {
                    if (m == n) {
                        return (double) (nums1[0] + nums2[n - 1]) / 2;
                    }
                    return nums2[half];
                }
                if (mmid == m - 1 && nums1[m - 1] <= nums2[0]) {
                    if (m == n) {
                        return (double) (nums1[m - 1] + nums2[0]) / 2;
                    }
                    return nums2[half - m];
                }
                int nmid = half - 1 - mmid;
                if (nmid > 0 && nums2[nmid - 1] > nums1[mmid]) {
                    mmin = mmid + 1;
                } else if (nmid < n - 1 && nums2[nmid + 1] < nums1[mmid]) {
                    mmax = mmid - 1;
                } else {
                    if ((m + n) % 2 == 0) {
                        return (double) (nums1[mmid] +
                                Math.min(mmid < m - 1 ? nums1[mmid + 1] : Integer.MAX_VALUE, nums2[nmid])) / 2;
                    }
                    return Math.max(nums1[mmid], nums2[nmid]);
                }
            }
            return 0;
        }


        /**
         * 10. Regular Expression Matching
         */

        public boolean isMatch2(String s, String p) {
            return false;
        }


        /**
         * 12. Integer to Roman
         *
         * @param num
         * @return
         */
        public String intToRoman(int num) {
            StringBuilder sb = new StringBuilder();
            while (num > 0) {
                if (num >= 1000) {
                    num = num - 1000;
                    sb.append('M');
                } else if (num >= 900) {
                    num = num - 900;
                    sb.append("CM");
                } else if (num >= 500) {
                    num = num - 500;
                    sb.append("D");
                } else if (num >= 400) {
                    num = num - 400;
                    sb.append("CD");
                } else if (num >= 100) {
                    num = num - 100;
                    sb.append("C");
                } else if (num >= 90) {
                    num = num - 90;
                    sb.append("XC");
                } else if (num >= 50) {
                    num = num - 50;
                    sb.append("L");
                } else if (num >= 40) {
                    num = num - 40;
                    sb.append("XL");
                } else if (num >= 10) {
                    num = num - 10;
                    sb.append("X");
                } else if (num >= 9) {
                    num = num - 9;
                    sb.append("IX");
                } else if (num >= 5) {
                    num = num - 5;
                    sb.append("V");
                } else if (num >= 4) {
                    num = num - 4;
                    sb.append("IV");
                } else {
                    sb.append("I");
                    num = num - 1;
                }
            }
            return sb.toString();

        }

        /**
         * 13. Roman to Integer
         *
         * @param s
         * @return
         */
        public int romanToInt(String s) {
            int result = 0;
            char[] chs = s.toCharArray();
            char pre = ' ';
            for (int i = chs.length - 1; i >= 0; i--) {
                switch (chs[i]) {
                    case 'I':
                        if (pre == 'V' || pre == 'X') {
                            result = result - 1;
                        } else {
                            result = result + 1;
                        }
                        break;
                    case 'V':
                        result = result + 5;
                        pre = 'V';
                        break;
                    case 'X':
                        if (pre == 'L' || pre == 'C') {
                            result = result - 10;
                        } else {
                            result = result + 10;
                        }
                        pre = 'V';
                        break;
                    case 'L':
                        result = result + 50;
                        pre = 'L';
                        break;
                    case 'C':
                        if (pre == 'D' || pre == 'M') {
                            result = result - 100;
                        } else {
                            result = result + 100;
                        }
                        pre = 'C';
                        break;
                    case 'D':
                        result = result + 500;
                        pre = 'D';
                        break;
                    case 'M':
                        result = result + 1000;
                        pre = 'M';
                        break;
                    default:
                        break;
                }

            }
            return result;
        }

        /**
         * 6. ZigZag Conversion
         *
         * @param s
         * @param numRows
         * @return
         */
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                boolean direction = true;
                for (int j = i; j < s.length(); ) {
                    if (i == 0 || i == numRows - 1) {
                        sb.append(s.charAt(j));
                        j = j + 2 * (numRows - 1);
                    } else {
                        sb.append(s.charAt(j));
                        if (direction) {
                            j = j + 2 * (numRows - i - 1);
                        } else {
                            j = j + 2 * i;
                        }
                        direction = !direction;
                    }
                }
            }
            return sb.toString();
        }

        /**
         * 4. Median of Two Sorted Arrays
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public double findMedianSortedArrays4(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
            }
            int m = nums1.length;
            int n = nums2.length;
            int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
            while (iMin < iMax) {
                int i = (iMin + iMax) / 2;
                int j = halfLen - i;
                if (i < iMax && nums2[j - 1] > nums1[i]) {
                    iMin = i + 1; // i is too small
                } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                    iMax = i - 1; // i is too big
                } else { // i is perfect
                    int maxLeft = 0;
                    if (i == 0) {
                        maxLeft = nums2[j - 1];
                    } else if (j == 0) {
                        maxLeft = nums1[i - 1];
                    } else {
                        maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                    }
                    if ((m + n) % 2 == 1) {
                        return maxLeft;
                    }
                    int minRight = 0;
                    if (i == m) {
                        minRight = nums2[j];
                    } else if (j == n) {
                        minRight = nums1[i];
                    } else {
                        minRight = Math.min(nums2[j], nums1[i]);
                    }
                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0.0;

        }


        /**
         * 20. Valid Parentheses
         *
         * @param s
         * @return
         */
        public boolean isValid(String s) {
            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                    stack.push(chars[i]);
                } else if (stack.isEmpty()) {
                    return false;
                } else {
                    char c = stack.pop();
                    if (c == '(' && chars[i] != ')') {
                        return false;
                    } else if (c == '[' && chars[i] != ']') {
                        return false;
                    } else if (c == '{' && chars[i] != '}') {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        /**
         * 28. Implement strStr()
         *
         * @param haystack
         * @param needle
         * @return
         */
        public int strStr(String haystack, String needle) {
            if (needle.equals("")) {
                return 0;
            }
            if (haystack.equals("")) {
                return -1;
            }
            char[] source = haystack.toCharArray();
            int sourceCount = source.length;
            char[] target = needle.toCharArray();
            int targetCount = target.length;

            char first = target[0];
            int max = sourceCount - targetCount;

            for (int i = 0; i <= max; i++) {
                /* Look for first character. */
                if (source[i] != first) {
                    while (++i <= max && source[i] != first) ;
                }

                /* Found first character, now look at the rest of v2 */
                if (i <= max) {
                    int j = i + 1;
                    int end = j + targetCount - 1;
                    for (int k = 1; j < end && source[j]
                            == target[k]; j++, k++)
                        ;

                    if (j == end) {
                        /* Found whole string. */
                        return i;
                    }
                }
            }
            return -1;
        }


        /**
         * 21. Merge Two Sorted Lists
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            while (l1 == null && l2 == null) {
                return null;
            }
            ListNode p = l1;
            ListNode q = l2;
            ListNode head = new ListNode(-1);
            ListNode cur = head;
            while (p != null && q != null) {
                if (p.val > q.val) {
                    cur.next = q;
                    q = q.next;
                } else {
                    cur.next = p;
                    p = p.next;
                }
                cur = cur.next;
            }
            if (p != null) {
                cur.next = p;
            } else {
                cur.next = q;
            }
            return head.next;
        }

        /**
         * 205. Isomorphic Strings
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isIsomorphic(String s, String t) {
            if (s.equals(t) || s.length() == 0) {
                return true;
            }
            char[] index = new char[26];
            for (int i = 0; i < s.length(); i++) {
                if (index[s.charAt(i) - 'a'] != '\0' && index[s.charAt(i) - 'a'] != '\0') {

                }
            }
            return false;


        }

        class Interval {
            int start;
            int end;

            Interval() {
                start = 0;
                end = 0;
            }

            Interval(int s, int e) {
                start = s;
                end = e;
            }
        }

        /**
         * 56. Merge Intervals
         *
         * @param intervals
         * @return
         */
        public List<Interval> merge(List<Interval> intervals) {
            List<Interval> result = new ArrayList<>();
            if (intervals == null || intervals.size() == 0) {
                return result;
            }
            intervals.sort(new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return o1.start - o2.start;
                }
            });
            int i = 0;
            Interval newInterval = intervals.get(0);
            while (i < intervals.size()) {
                if (i == intervals.size() - 1) {
                    result.add(newInterval);
                    break;
                }
                if (intervals.get(i + 1).start <= newInterval.end) {
                    newInterval.end = Math.max(intervals.get(i + 1).end, newInterval.end);
                } else {
                    result.add(newInterval);
                    newInterval = intervals.get(i + 1);
                }
                i++;
            }
            return result;
        }

        /**
         * 57. Insert Interval
         *
         * @param intervals
         * @param newInterval
         * @return
         */
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            List<Interval> result = new LinkedList<>();
            int i = 0;
            // add all the intervals ending before newInterval starts
            while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
                result.add(intervals.get(i));
                i++;
            }
            // merge all overlapping intervals to one considering newInterval
            while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
                newInterval = new Interval( // we could mutate newInterval here also
                        Math.min(newInterval.start, intervals.get(i).start),
                        Math.max(newInterval.end, intervals.get(i).end));
                i++;
            }
            result.add(newInterval); // add the union of intervals we got
            // add all the rest
            while (i < intervals.size()) result.add(intervals.get(i++));
            return result;
        }

        /**
         * 58. Length of Last Word
         *
         * @param s
         * @return
         */
        public int lengthOfLastWord(String s) {
            if (s == null && s.length() == 0) {
                return 0;
            }
            int lenOfLastWord = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) != ' ') {
                    lenOfLastWord++;
                } else if (lenOfLastWord == 0) {
                    continue;
                } else {
                    break;
                }
            }
            return lenOfLastWord;
        }

        /**
         * 54. Spiral Matrix
         *
         * @param matrix
         * @return
         */
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new LinkedList<>();
            if (matrix == null || matrix.length == 0) {
                return result;
            }
            int ilow = 0;
            int ihigh = matrix.length - 1;
            int jleft = 0;
            int jright = matrix[0].length - 1;
            while (ilow <= ihigh && jleft <= jright) {
                for (int j = jleft; j <= jright; j++) {
                    result.add(matrix[ilow][j]);
                }
                for (int i = ilow + 1; i <= ihigh; i++) {
                    result.add(matrix[i][jright]);
                }
                for (int j = jright - 1; j >= jleft && ilow != ihigh; j--) {
                    result.add(matrix[ihigh][j]);
                }
                for (int i = ihigh - 1; i > ilow && jleft != jright; i--) {
                    result.add(matrix[i][jleft]);
                }
                ilow++;
                ihigh--;
                jleft++;
                jright--;
            }
            return result;
        }

        /**
         * 59. Spiral Matrix II
         *
         * @param n
         * @return
         */
        public int[][] generateMatrix(int n) {
            if (n == 0) {
                return new int[][]{};
            }
            int[][] matrix = new int[n][n];
            int ilow = 0;
            int ihigh = n - 1;
            int jleft = 0;
            int jright = n - 1;
            int k = 0;
            while (ilow <= ihigh && jleft <= jright) {
                for (int j = jleft; j <= jright; j++) {
                    matrix[ilow][j] = k++;
                }
                for (int i = ilow + 1; i <= ihigh; i++) {
                    matrix[i][jright] = k++;
                }
                for (int j = jright - 1; j >= jleft && ilow != ihigh; j--) {
                    matrix[ihigh][j] = k++;
                }
                for (int i = ihigh - 1; i > ilow && jleft != jright; i--) {
                    matrix[i][jleft] = k++;
                }
                ilow++;
                ihigh--;
                jleft++;
                jright--;
            }
            return matrix;
        }

        /**
         * 61. Rotate List
         *
         * @param head
         * @param k
         * @return
         */
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || k == 0) {
                return head;
            }
            ListNode curr = head;
            ListNode last = null;
            int len = 0;
            while (curr != null) {
                len++;
                last = curr;
                curr = curr.next;
            }
            k = k % len;
            if (k == 0) {
                return head;
            }
            k = len - k;
            curr = head;
            ListNode pre = curr;
            while (k > 0) {
                pre = curr;
                curr = curr.next;
                k--;
            }
            pre.next = null;
            last.next = head;
            return curr;
        }


        /**
         * 97. Interleaving String
         *
         * @param s1
         * @param s2
         * @param s3
         * @return
         */
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0)
                return true;
            if (s3.length() > 0) {
                if (s1.length() > 0 && s1.charAt(0) == s3.charAt(0))
                    if (isInterleave(s1.substring(1), s2, s3.substring(1))) return true;
                if (s2.length() > 0 && s2.charAt(0) == s3.charAt(0))
                    if (isInterleave(s1, s2.substring(1), s3.substring(1))) return true;
            }
            return false;
        }

        /**
         * 87. Scramble String
         *
         * @param s1
         * @param s2
         * @return
         */
        public boolean isScramble(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            if (s1.equals(s2)) {
                return true;
            }
            int[] nums = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                nums[s1.charAt(i) - 'a']++;
                nums[s2.charAt(i) - 'a']--;
            }
            for (int i = 0; i < 26; i++) {
                if (nums[i] != 0) {
                    return false;
                }
            }
            for (int i = 1; i < s1.length(); i++) {
                if (isScramble(s1.substring(0, i), s2.substring(0, i))
                        && isScramble(s1.substring(i), s2.substring(i))) {
                    return true;
                }
                if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                        && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 78. Subsets
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            Arrays.sort(nums);
            backtrack(list, new ArrayList<>(), nums, 0);
            return list;
        }

        private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
            list.add(new ArrayList<>(tempList));
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }

        /**
         * 90. Subsets II
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> subsetsWithDup2(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            Arrays.sort(nums);
            backtrack(list, new ArrayList<>(), nums, 0);
            return list;
        }

        private void backtrackWithDup(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
            list.add(new ArrayList<>(tempList));
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }

        /**
         * 39. Combination Sum
         *
         * @param candidates
         * @param target
         * @return
         */
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            Arrays.sort(candidates);
            for (int i = 0; i < candidates.length; i++) {

//                int remain = target -
            }
            return null;
        }


        /**
         * 38. Count and Say
         *
         * @param n
         * @return
         */
        public String countAndSay(int n) {
            if (n <= 0) return "";
            StringBuilder sb = new StringBuilder();
            String s = "1";
            while (n > 1) {
                int count = 1;
                char lastChar = s.charAt(0);
                for (int i = 1; i < s.length(); i++) {
                    if (s.charAt(i) == lastChar) {
                        count++;
                    } else {
                        sb.append(count).append(lastChar);
                        count = 1;
                        lastChar = s.charAt(i);
                    }
                }
                sb.append(count).append(lastChar);
                s = sb.toString();
                sb.setLength(0);
                n--;
            }
            return s;
        }

        /**
         * 38. Count and Say
         *
         * @param n
         * @return
         */
        public String countAndSay2(int n) {
            StringBuilder curr = new StringBuilder("1");
            StringBuilder prev;
            int count;
            char say;
            for (int i = 1; i < n; i++) {
                prev = curr;
                curr = new StringBuilder();
                count = 1;
                say = prev.charAt(0);

                for (int j = 1; j < prev.length(); j++) {
                    if (prev.charAt(j) != say) {
                        curr.append(count).append(say);
                        count = 1;
                        say = prev.charAt(j);
                    } else count++;
                }
                curr.append(count).append(say);
            }
            return curr.toString();

        }

        /**
         * 43. Multiply Strings
         *
         * @param num1
         * @param num2
         * @return
         */
        public String multiply(String num1, String num2) {
            int m = num1.length();
            int n = num2.length();
            int[] pos = new int[m + n];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    sum = sum + pos[i + j + 1];
                    pos[i + j + 1] = sum % 10;
                    pos[i + j] += sum / 10;
                }
            }
            StringBuffer re = new StringBuffer();
            for (int k : pos) {
                if (re.length() != 0 || k != 0) {
                    re.append(k);
                }
            }
            return re.length() == 0 ? "0" : re.toString();
        }

        public int reverse(int x) {
            int minus = 1;
            if (x < 0) {
                minus = -1;
            }
            int result = 0;
            int m = Math.abs(minus == 1 ? Integer.MAX_VALUE / 10 : Integer.MIN_VALUE / 10);
            int n = Math.abs(minus == 1 ? Integer.MAX_VALUE % 10 : Integer.MIN_VALUE % 10);

            while (x != 0) {
                int remainder = x % 10;
                if (Math.abs(result) > m || (Math.abs(result) == m && Math.abs(remainder) > n)) {
                    return 0;
                }
                result = (result * 10 + remainder);
                x = x / 10;
            }
            return result;
        }

        public int myAtoi(String str) {
            if (str.equals("")) {
                return 0;
            }
            int i = 0;
            char[] chs = str.toCharArray();
            int minus = 1;
            int result = 0;
            while (i < chs.length && chs[i] == ' ') {
                i++;
            }
            if (i < chs.length && chs[i] == '-') {
                i++;
                minus = -1;
            } else if (i < chs.length && chs[i] == '+') {
                i++;
            } else if (i < chs.length && (chs[i] - '0' > 9 || chs[i] - '0' < 0)) {
                return 0;
            }

            int m = Math.abs(minus == 1 ? Integer.MAX_VALUE / 10 : Integer.MIN_VALUE / 10);
            int n = Math.abs(minus == 1 ? Integer.MAX_VALUE % 10 : Integer.MIN_VALUE % 10);

            for (; i < chs.length; i++) {
                if (chs[i] - '0' > 9 || chs[i] - '0' < 0) {
                    break;
                }
                if (result > m || (result == m && chs[i] - '0' > n)) {
                    return minus == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = result * 10 + chs[i] - '0';
            }
            return result * minus;
        }

        /**
         * 5. Longest Palindromic Substring
         *
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            char[] ss = s.toCharArray();
            int maxlen = 0;
            int left = 0;
            int right = 0;
            int curlen = 0;
            for (int i = 0; i < ss.length; i++) {
                for (curlen = 0;
                     i - curlen >= 0
                             && i + curlen < ss.length
                             && ss[i - curlen] == ss[i + curlen]
                        ; curlen++
                ) {
                }
                if (curlen > maxlen) {
                    maxlen = curlen;
                    left = i - (curlen - 1);
                    right = i + curlen;
                }
            }
            for (int i = 1; i < ss.length; i++) {
                for (curlen = 0;
                     i - (curlen + 1) >= 0
                             && i + curlen < ss.length
                             && ss[i - (curlen + 1)] == ss[i + curlen];
                     curlen++) {
                }
                if (curlen >= maxlen) {
                    maxlen = curlen;
                    left = i - curlen;
                    right = i + curlen;
                }
            }
            return s.substring(left, right);
        }

        public double findMedianSortedArrays3(int[] A, int[] B) {
            int m = A.length;
            int n = B.length;
            if (m > n) { // to ensure m<=n
                int[] temp = A;
                A = B;
                B = temp;
                int tmp = m;
                m = n;
                n = tmp;
            }
            int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                int j = halfLen - i;
                if (i < iMax && B[j - 1] > A[i]) {
                    iMin = i + 1; // i is too small
                } else if (i > iMin && A[i - 1] > B[j]) {
                    iMax = i - 1; // i is too big
                } else { // i is perfect
                    int maxLeft = 0;
                    if (i == 0) {
                        maxLeft = B[j - 1];
                    } else if (j == 0) {
                        maxLeft = A[i - 1];
                    } else {
                        maxLeft = Math.max(A[i - 1], B[j - 1]);
                    }
                    if ((m + n) % 2 == 1) {
                        return maxLeft;
                    }

                    int minRight = 0;
                    if (i == m) {
                        minRight = B[j];
                    } else if (j == n) {
                        minRight = A[i];
                    } else {
                        minRight = Math.min(B[j], A[i]);
                    }

                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0.0;
        }

        public int lengthOfLongestSubstring(String s) {
            if (s.equals("")) {
                return 0;
            }
            int[] index = new int[256];
            char[] chars = s.toCharArray();
            int longest = Integer.MIN_VALUE;
            int curlong = 0;
            for (int i = 0; i < s.length(); i++) {
                curlong++;
                curlong = Integer.min(curlong, i - index[chars[i]] + 1);
                longest = Integer.max(curlong, longest);
                index[chars[i]] = i + 1;
            }
            return longest;
        }


        public int compareVersion(String version1, String version2) {
            String v1[] = version1.split("\\.");
            String v2[] = version2.split("\\.");
            int len1 = v1.length;
            int len2 = v2.length;
            int i = 0;
            while (i < len1 && i < len2) {
                if (Integer.parseInt(v1[i]) == Integer.parseInt(v2[i])) {
                    i++;
                    continue;
                } else {
                    return Integer.parseInt(v1[i]) > Integer.parseInt(v2[i]) ?
                            1 : -1;
                }
            }
            if (len1 > len2) {
                while (i < len1) {
                    if (Integer.parseInt(v1[i]) > 0) {
                        return 1;
                    }
                    i++;
                }
            } else if (len1 < len2) {
                while (i < len2) {
                    if (Integer.parseInt(v2[i]) > 0) {
                        return -1;
                    }
                    i++;
                }
            }
            return 0;
        }


        public int[] twoSum(int[] numbers, int target) {
            int i = 0;
            int j = numbers.length - 1;

            return new int[]{i, j};
        }

        public String reverseWords2(String s) {
            if (s.length() == 0) {
                return s;
            }
            int left = 0, right = 0, i = 0;
            char[] arrs = s.toCharArray();
            while (i < s.length()) {
                while (i < s.length() && arrs[i] == ' ') {
                    i++;
                }
                if (i >= s.length())
                    break;
                if (left != right) {
                    arrs[right++] = ' ';
                }
                left = right;
                while (i < s.length() && arrs[i] != ' ') {
                    arrs[right++] = arrs[i++];
                }
                reverseChars(arrs, left, right);
            }
//            s.resize(right);
            reverseChars(arrs, 0, s.length() - 1);
            return new String(arrs);
        }


        public String reverseWords(String s) {
            char[] arrs = s.toCharArray();
            reverseChars(arrs, 0, arrs.length);
            int left = 0;
            int right = 0;
            StringBuilder sb = new StringBuilder();
            boolean t = false;
            for (int i = 0; i < arrs.length; i++) {
                while (!t && arrs[i++] == ' ') {
                    left = i;
                    t = true;
                }
                if (t && arrs[i] == ' ') {
                    right = i;
                    t = false;
                }
            }
            return new String(arrs);
        }

        public void reverseChars(char[] chars, int pos, int length) {
            int i = pos;
            int j = length - 1;
            for (; i < j; i++, j--) {
                swap(chars, i, j);
            }
        }

        private void swap(char[] arrs, int i, int j) {
            char temp = arrs[i];
            arrs[i] = arrs[j];
            arrs[j] = temp;
        }

        private void swap(int[] arrs, int i, int j) {
            int temp = arrs[i];
            arrs[i] = arrs[j];
            arrs[j] = temp;
        }
    }
}
