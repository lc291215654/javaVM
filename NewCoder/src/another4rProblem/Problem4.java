package another4rProblem;

import my.li.org.binary.ListNode;
import my.li.org.binary.TreeNode;

import java.util.*;

/**
 * Created by licheng on 3/8/19.
 */
public class Problem4 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.largestNumber(new int[]{3,30,34,5,9}));
    }



    /**
     * 173. Binary Search Tree Iterator
     */
    class BSTIterator {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur;

        public BSTIterator(TreeNode root) {
            cur = root;
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int re = cur.data;
            cur = cur.right;
            return re;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }

    static class Solution {

        /**
         * Wow,genius!Amazing!Brilliant!Jesus!Excellent!Wonderful!Nice!Beautiful!Marvelous!Great!Elegant!Niubility!Unbelievable!
         */
        /**
         * 190. Reverse Bits
         * @param n
         * @return
         */
        public int reverseBits(int n) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                result += n & 1;
                n >>>= 1;   // CATCH: must do unsigned shift
                if (i < 31) // CATCH: for last digit, don't shift!
                    result <<= 1;
            }
            return result;
        }

        /**
         * 187. Repeated DNA Sequences
         * @param s
         * @return
         */
        public List<String> findRepeatedDnaSequences(String s) {
            Set seen = new HashSet();
            Set repeated = new HashSet();
            for (int i = 0; i + 9 < s.length(); i++) {
                String ten = s.substring(i, i + 10);
                if (!seen.add(ten))
                    repeated.add(ten);
            }
            return new ArrayList(repeated);
        }

        /**
         * 187. Repeated DNA Sequences
         * @param s
         * @return
         */
        public List<String> findRepeatedDnaSequences2(String s) {
            Set<Integer> words = new HashSet<>();
            Set<Integer> doubleWords = new HashSet<>();
            List<String> rv = new ArrayList<>();
            char[] map = new char[26];
            //map['A' - 'A'] = 0;
            map['C' - 'A'] = 1;
            map['G' - 'A'] = 2;
            map['T' - 'A'] = 3;

            for(int i = 0; i < s.length() - 9; i++) {
                int v = 0;
                for(int j = i; j < i + 10; j++) {
                    v <<= 2;
                    v |= map[s.charAt(j) - 'A'];
                }
                if(!words.add(v) && doubleWords.add(v)) {
                    rv.add(s.substring(i, i + 10));
                }
            }
            return rv;
        }

        /**
         * 179. Largest Number
         * @param nums
         * @return
         */
        public String largestNumber(int[] nums) {
            String[] arrs = new String[nums.length];
            for(int i = 0;i<nums.length;i++){
                arrs[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(arrs, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String order1 = o1 + o2;
                    String order2 = o2 + o1;
                    return order2.compareTo(order1);
                }
            });
            StringBuffer sb = new StringBuffer();
            for(String s:arrs){
                sb.append(s);
            }
            return sb.toString();
        }

        /**
         * 172. Factorial Trailing Zeroes
         *
         * @param n
         * @return
         */
        public int trailingZeroes(int n) {
            int countOf5 = 0;
            long divider = 5;
            while (n / divider > 0) {
                countOf5 += (n / divider);
                divider *= 5;
            }
            return countOf5;
        }

        /**
         * 171. Excel Sheet Column Number
         *
         * @param s
         * @return
         */
        public int titleToNumber(String s) {
            int re = 0;
            for (int i = 0; i < s.length(); i++) {
                re = re * 26 + (s.charAt(i) - 'A' + 1);
            }
            return re;
        }

        /**
         * 169. Majority Element
         *
         * @param nums
         * @return
         */
        public int majorityElement(int[] nums) {
            int re = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (count == 0) {
                    re = nums[i];
                    count++;
                } else if (re == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
            return re;
        }

        /**
         * 168. Excel Sheet Column Title
         *
         * @param n
         * @return
         */
        public String convertToTitle(int n) {
            int k = 0;
            StringBuffer s = new StringBuffer();
            while (n > 0) {
                k = (n - 1) % 26;
                int c = 'A' + k;
                s.append((char) c);
                n = (n - 1) / 26;
            }
            return s.reverse().toString();
        }


        /**
         * 174. Dungeon Game
         *
         * @param dungeon
         * @return
         */
        public int calculateMinimumHP(int[][] dungeon) {
            int m = dungeon.length;
            int n = dungeon[0].length;
            int[][] dp = new int[m][n];
            dp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
            for (int i = m - 2; i >= 0; i--) {
                dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
            }
            for (int j = n - 2; j >= 0; j--) {
                dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
            }
            for (int i = m - 2; i >= 0; i--) {
                for (int j = n - 2; j >= 0; j--) {
                    dp[i][j] = Math.max(Math.min(dp[i + 1][j] - dungeon[i][j], dp[i][j + 1] - dungeon[i][j]), 1);
                }
            }
            return dp[0][0];
        }


        /**
         * 162. Find Peak Element
         *
         * @param nums
         * @return
         */
        public int findPeakElement(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums[1] < nums[0]) {
                return 1;
            }
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    return i;
                }
            }
            if (nums[nums.length - 2] < nums[nums.length - 1]) {
                return nums.length - 1;
            }
            return -1;
        }

        /**
         * 160. Intersection of Two Linked Lists
         *
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            int len = 0;
            ListNode curA = headA;
            ListNode curB = headB;
            while (curA != null && curB != null) {
                curA = curA.next;
                curB = curB.next;
            }
            if (curB != null) {
                curA = curB;
                ListNode temp = headA;
                headA = headB;
                headB = temp;
            }
            while (curA != null) {
                len++;
            }
            while (len > 0) {
                headA = headA.next;
                len--;
            }
            while (headA != null && headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }

        /**
         * 153. Find Minimum in Rotated Sorted Array
         *
         * @param nums
         * @return
         */
        public int findMin(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int left = 0;
            int right = nums.length - 1;
            if (nums[right] > nums[0]) {
                return nums[0];
            }
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else if (nums[mid] < nums[right]) {
                    right = mid;
                } else {
                    right--;
                }
            }
            return nums[left];
        }

        /**
         * 154. Find Minimum in Rotated Sorted Array II
         *
         * @param nums
         * @return
         */
        public int findMin2(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int left = 0;
            int right = nums.length - 1;
            if (nums[right] > nums[0]) {
                return nums[0];
            }
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] > nums[left]) {
                    left = mid + 1;
                } else if (nums[mid] < nums[right]) {
                    right = mid;
                } else {
                    right--;
                }
            }
            return nums[left];
        }

        /**
         * 152. Maximum Product Subarray
         *
         * @param nums
         * @return
         */
        public int maxProduct(int[] nums) {
            int curmax = 1;
            int curmin = -1;
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                curmax *= nums[i];
                result = Math.max(result, curmax);
                if (curmax < 0) {
                    curmax = nums[i];
                }
            }
            return result;
        }

        /**
         * 151. Reverse Words in a String
         *
         * @param s
         * @return
         */
        public String reverseWords(String s) {

            ArrayList<String> arr = new ArrayList<>();
            char[] chars = s.toCharArray();
            int i = 0;
            boolean has = true;
            StringBuffer sb = new StringBuffer();
            while (i < chars.length) {
                if (has && chars[i] == ' ' && sb.length() == 0) {
                    i++;
                    continue;
                }
                if (chars[i] == ' ') {
                    arr.add(sb.toString());
                    sb.setLength(0);
                    i++;
                    has = true;
                } else {
                    sb.append(chars[i]);
                    if (i == chars.length - 1) {
                        arr.add(sb.toString());
                    }
                    has = false;
                    i++;
                }
            }
            sb.setLength(0);
            int n = arr.size() - 1;
            while (n >= 0) {
                if (n == 0) {
                    sb.append(arr.get(n));
                    break;
                }
                sb.append(arr.get(n) + " ");
                n--;
            }
            return sb.toString();

        }
    }
}
