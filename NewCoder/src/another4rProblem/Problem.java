package another4rProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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

        int[] A = new int[]{1, 2, 3, 4, 5, 6};

        int[] B = new int[]{7, 8, 9, 10, 11, 12};

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node7.next = node8;

        ListNode[] lists = new ListNode[]{node1, node4, node7};


        System.out.println(solution.mergeKLists(lists));

        System.out.println();


    }


    static class Solution {

        /**
         * 25. Reverse Nodes in k-Group
         * @param head
         * @param k
         * @return
         */
        public ListNode reverseKGroup(ListNode head, int k) {
            return null;

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
            int row = 81 / 9;
            int col = 81 % 9;
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

            //check row, col, subgrid
            for (int i = 0; i < 9; i++) {
                //check row
                if (i != col && board[row][i] == board[row][col])
                    return false;

                //check col
                if (i != row && board[i][col] == board[row][col])
                    return false;

                //check subgrid
                int r = gid / 3 * 3 + i / 3;
                int c = gid % 3 * 3 + i % 3;
                if ((r != row || c != col) && board[r][c] == board[row][col])
                    return false;
            }
            return true;
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
            int imin = 0, imax = m - 1;
            int half = (m + n - 1) / 2;
            while (imin <= imax) {
                int mid = (imin + imax) / 2;
                int left = half - mid;

            }
            return 0;
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
            return "";

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
         * 43. Multiply Strings
         *
         * @param num1
         * @param num2
         * @return
         */
        public String multiply(String num1, String num2) {
            return "";

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

        public String longestPalindrome(String s) {

            return "";

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
    }
}
