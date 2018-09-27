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

        int[] A = new int[]{1};
        int[] B = new int[]{1};


//        System.out.println(solution.findMedianSortedArrays2(A, B));
        boolean aa = solution.isMatch("aa","ab");
        System.out.println(aa);
        System.out.println();


    }


    static class Solution {

        /**
         * 10. Regular Expression Matching
         * @param s
         * @param p
         * @return
         */
        public boolean isMatch(String s, String p) {
            if(p.isEmpty()){
                return s.isEmpty();
            }

            boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
            if(p.length() >=2 && p.charAt(1) == '*'){
                return (isMatch(s, p.substring(2)) ||
                        (first_match && isMatch(s.substring(1), p)));
            }else {
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

        public double findMedianSortedArrays(int[] A, int[] B) {
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
            int iMin = 0, iMax = m, halfLen = (m + n - 1) / 2;
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
