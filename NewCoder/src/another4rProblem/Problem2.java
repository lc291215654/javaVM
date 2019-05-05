package another4rProblem;

import ProgrammingProblem.leetcode.Solution;
import my.li.org.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by licheng on 3/8/19.
 */
public class Problem2 {

    static class Solution {
        /**
         * 56. Merge Intervals
         *
         * @param intervals
         * @return
         */
        public List<ProgrammingProblem.leetcode.Solution.Interval> merge(List<ProgrammingProblem.leetcode.Solution.Interval> intervals) {
            List<ProgrammingProblem.leetcode.Solution.Interval> result = new ArrayList<>();
            return result;
        }



        /**
         * 63. Unique Paths II
         *
         * @param obstacleGrid
         * @return
         */
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid == null || obstacleGrid.length == 0) {
                return 0;
            }
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];
            for (int i = 1; i < m; i++) {
                if (obstacleGrid[i][0] == 1) {
                    break;
                }
                dp[i][0] = 1;
            }
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[0][j] == 1) {
                    break;
                }
                dp[0][j] = 1;
            }
            if (n < 2 || m < 2) {
                return dp[n - 1][n - 1];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    }
                }
            }
            return dp[n - 1][n - 1];
        }

        /**
         * 68. Text Justification
         *
         * @param words
         * @param maxWidth
         * @return
         */
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < words.length; ) {
                int k = 1;
                int temp = maxWidth - words[i].length();
                while (i + k < words.length && words[i + k].length() + 1 <= temp) {
                    temp = temp - words[i + k].length() - 1;
                    k++;
                }
                String s = new String();
                if (k == 1) {
                    s += words[i];
                    for (int j = 0; j < temp; j++) {
                        s = s + " ";
                    }
                } else if (i + k == words.length) {
                    s += words[i];
                    for (int j = 1; j < k; j++) {
                        s = s + " " + words[i + j];
                    }
                    int white = maxWidth - s.length();
                    for (int c = 0; c < white; c++) {
                        s = s + " ";
                    }
                } else {
                    s += words[i];
                    for (int j = 1; j < k; j++) {
                        s += " ";
                        if (temp > 0 && k > 1) {
                            for (int c = 0; c < temp / (k - 1); c++) {
                                s += " ";
                            }
                            if (j - 1 < (temp % (k - 1))) {
                                s += " ";
                            }
                        }
                        s += words[i + j];
                    }
                }
                result.add(s);
                i += k;
            }
            return result;
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
            int right = x / 2;
            int mid = (right + left) / 2;
            while (left < right) {
                if (mid <= x / mid && (mid + 1) > (x / (mid + 1))) {
                    return mid;
                }
                if (mid > x / mid) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                mid = (right + left) / 2;
            }
            return left;
        }

        /**
         * 85. Maximal Rectangle
         * @param matrix
         * @return
         */
        public int maximalRectangle(char[][] matrix) {

            return 0;

        }

        /**
         * 86. Partition List
         *
         * @param head
         * @param x
         * @return
         */
        public Problem1.ListNode partition(Problem1.ListNode head, int x) {
            if (head == null || head.next == null) {
                return head;
            }
            Problem1.ListNode cur = head;
            Problem1.ListNode small = new Problem1.ListNode(-1);
            Problem1.ListNode big = new Problem1.ListNode(-1);
            Problem1.ListNode bighead = big;
            head = small;
            while (cur != null) {
                if (cur.val < x) {
                    small.next = cur;
                    small = small.next;
                } else {
                    big.next = cur;
                    big = big.next;
                }
                cur = cur.next;
            }
            small.next = bighead.next;
            big.next = null;
            return head.next;
        }

        /**
         * 88. Merge Sorted Array
         *
         * @param nums1
         * @param m
         * @param nums2
         * @param n     nums2.length must larger or equal m
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i1 = 0;
            int left2 = 0;
            int right2 = 0;
            int i2 = 0;
            while (i1 < m && i2 < n) {
                if (nums1[i1] > nums2[i2]) {
                    if (left2 < right2 && nums2[left2] < nums2[i2]) {
                        int temp = nums2[left2];
                        nums2[right2] = nums1[i1];
                        nums1[i1] = temp;
                        i1++;
                        left2++;
                        right2++;
                    } else {
                        int temp = nums1[i1];
                        nums1[i1] = nums2[i2];
                        i1++;
                        i2++;
                        nums2[right2] = temp;
                        right2++;
                    }
                } else {
                    if (left2 < right2) {
                        int temp = nums1[i1];
                        nums1[i1] = nums2[left2];
                        nums2[right2] = temp;
                        i1++;
                        right2++;
                        left2++;
                    } else {
                        i1++;
                    }
                }
            }
            if (i2 == n) {
                while (left2 < right2 && i1 < m) {
                    nums2[right2++] = nums1[i1];
                    nums1[i1] = nums2[left2++];
                    i1++;
                }
                while (left2 < right2) {
                    nums1[i1] = nums2[left2++];
                    i1++;
                }

            } else if (i1 == m) {
                while (left2 < right2 && i2 < n) {
                    if (nums2[left2] < nums2[i2]) {
                        nums1[i1++] = nums2[left2++];
                    } else {
                        nums1[i1++] = nums2[i2++];
                    }
                }
                while (left2 < right2) {
                    nums1[i1++] = nums2[left2++];
                }
                while (i2 < n) {
                    nums1[i1++] = nums2[i2++];
                }
            }
        }

        public void merge2(int[] nums1, int m, int[] nums2, int n) {
            int len = m + n - 1;
            int i = m - 1;
            int j = n - 1;
            while (i >= 0 && j >= 0) {
                if (nums1[i] >= nums2[j]) {
                    nums1[len--] = nums1[i--];
                } else {
                    nums1[len--] = nums2[j--];
                }
            }
            while (j >= 0) {
                nums1[len--] = nums2[j--];
            }
        }

        /**
         * 89. Gray Code
         *
         * @param n
         * @return
         */
        public List<Integer> grayCode(int n) {

            return null;

        }

        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();

            int[][] cost = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++)
                cost[i][0] = i;
            for (int i = 1; i <= n; i++)
                cost[0][i] = i;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (word1.charAt(i) == word2.charAt(j))
                        cost[i + 1][j + 1] = cost[i][j];
                    else {
                        int a = cost[i][j];
                        int b = cost[i][j + 1];
                        int c = cost[i + 1][j];
                        cost[i + 1][j + 1] = Math.min(Math.min(a, b), c) + 1;
                    }
                }
            }
            return cost[m][n];
        }

        /**
         * 98. Validate Binary Search Tree
         *
         * @param root
         * @return
         */
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
        }


        private boolean isValidBST(TreeNode root, long maxValue, long minValue) {
            if (root == null) {
                return true;
            }
            return root.data > minValue && root.data < maxValue && isValidBST(root.left, root.data, minValue)
                    && isValidBST(root.right, maxValue, root.data);
        }

        /**
         * 99. Recover Binary Search Tree
         *
         * @param root
         */
        public void recoverTree(TreeNode root) {
            TreeNode[] first = new TreeNode[1];
            TreeNode[] second = new TreeNode[1];
            TreeNode[] pre = new TreeNode[1];
            pre[0] = new TreeNode(Integer.MIN_VALUE);
            traverse(root, first, pre, second);
            int temp = first[0].data;
            first[0].data = second[0].data;
            second[0].data = temp;
        }

        private void traverse(TreeNode root, TreeNode[] first, TreeNode[] pre, TreeNode[] second) {
            if (root == null) {
                return;
            }
            traverse(root.left, first, pre, second);
            if (first[0] == null && pre[0].data >= root.data) {
                first[0] = pre[0];
            }
            if (first[0] != null && pre[0].data >= root.data) {
                second[0] = root;
            }
            pre[0] = root;
            traverse(root.right, first, pre, second);
        }
    }
}
