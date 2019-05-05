package another4rProblem;

import java.util.HashMap;
import java.util.Map;

import my.li.org.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = 9;
        int j = -i;
        int k = i & j;

//        int re = solution.binaryTreePaths();
//        System.out.println(re);
        System.out.println();
    }

    static class Solution {

        /**
         * 263. Ugly Number
         * @param num
         * @return
         */
        public boolean isUgly(int num) {
            if(num < 1){
                return false;
            }
            while (num % 5 == 0 ){
                num = num / 5;
            }
            while (num % 3 == 0 ){
                num = num / 3;
            }
            while (num % 2 == 0 ){
                num = num / 2;
            }
            return num == 1;
        }

        /**
         * 264. Ugly Number II
         * @param n
         * @return
         */
        public int nthUglyNumber(int n) {
            int[] nums = new int[n];
            int i = 0,j = 0,k = 0;
            int cur = 1;
            nums[0] = 1;
            while (cur < n){
                int min = Math.min(Math.min(nums[i] * 2,nums[j] * 3),nums[k] * 5);
                if(min == nums[i] * 2){
                    i++;
                }
                if(min == nums[j] * 3){
                    j++;
                }
                if(min == nums[k] * 5){
                    k++;
                }
                nums[cur++] = min;
                cur++;
            }
            return nums[n -1];
        }

        /**
         * 290. Word Pattern
         * @param pattern
         * @param str
         * @return
         */
        public boolean wordPattern(String pattern, String str) {
            if(pattern.equals("") && str.equals("")){
                return true;
            }
            char[] ps = pattern.toCharArray();
            String[] strs = str.split(" ");
            if(ps.length != strs.length){
                return false;
            }
            Map index = new HashMap();
            for(int i=0;i<ps.length;i++){
                if (index.put(ps[i], i) != index.put(strs[i], i))
                    return false;
            }
            return true;
        }
        /**
         * 257. Binary Tree Paths
         *
         * @param root
         * @return
         */
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root != null) {
                binaryTreePathsHelper(root, "", res);
            }
            return res;
        }

        public void binaryTreePathsHelper(TreeNode root, String cur, List<String> list) {
            if (root.left == null && root.right == null) {
                list.add(cur + root.data);
            }
            if (root.left != null) binaryTreePathsHelper(root.left, cur + root.data + "->", list);
            if (root.right != null) binaryTreePathsHelper(root.right, cur + root.data + "->", list);
        }

        /**
         * 260. Single Number III
         *
         * @param nums
         * @return
         */
        public int[] singleNumber(int[] nums) {
            int dif = 0;
            for (int num : nums) {
                dif ^= num;
            }
            dif &= -dif;
            int[] res = {0, 0};
            for (int num : nums) {
                if ((num & dif) == 0) {
                    res[0] ^= num;
                } else {
                    res[1] ^= num;
                }
            }
            return res;
        }

        /**
         * 263. Ugly Number
         *
         * @param num
         * @return
         */
        public boolean isUgly2(int num) {
            return false;
        }

        public int missingNumber(int[] nums) {
            int missing = nums.length;
            for(int i=0;i<nums.length;i++){
                missing ^= i^nums[i];
            }
            return missing;
        }

        public int hIndex(int[] citations) {
            int n = citations.length;
            int[] bucket = new int[n + 1];
            for(int c:citations){
                if(c >=n){
                    bucket[n]++;
                }else {
                    bucket[c]++;
                }
            }
            int count = 0;
            for(int i = n;i>=0;i--){
                count+=bucket[i];
                if(count >= i){
                    return i;
                }
            }
            return 0;
        }

        /**
         * 275. H-Index II
         * @param citations
         * @return
         */
        public int hIndex2(int[] citations) {
            int count = 0;
            for(int i = citations.length - 1;i>=0;i--){
                if(citations[i] >=i){
                    count++;
                }
                if(count >= citations[i]){
                    return citations[i];
                }
            }
            return 0;
        }

        /**
         * 278. First Bad Version
         * @param n
         * @return
         */
        public int firstBadVersion(int n) {
            int left = 1;
            int right = n;
            while (left < right){
                int mid =  left + (right - left) /2;
                if(isBadVersion(mid)){
                    right = mid;
                }else {
                    left = mid + 1;
                }
            }
            return left;

        }

        public boolean isBadVersion(int n){
            return true;
        }

        /**
         * 279. Perfect Squares
         * @param n
         * @return
         */
        public int numSquares(int n) {
            return 0;

        }



    }
}