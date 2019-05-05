package another4rProblem;

import java.util.Arrays;
import java.util.HashSet;

public class Problem7 {

    public static void main(String[] srgs){
        Solution solution = new Solution();
        solution.reverseString("1807".toCharArray());
        System.out.println();
    }
    static class Solution {


        /**
         * 349. Intersection of Two Arrays
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();

            for(int i=0;i < nums1.length ;i++){
                set1.add(nums1[i]);
            }
            for(int i = 0;i < nums2.length;i++){
                if(!set1.add(nums2[i])){
                    set2.add(nums2[i]);
                }
            }
            int[] re = new int[set2.size()];
            int i = 0;
            for(int k : set2){
                re[i++] = k;
            }
            return re;
        }



        public void reverseString(char[] s) {
            int i = 0;
            int j = s.length - 1;
            while (i < j){
                char tmp = s[j];
                s[j--] = s[i];
                s[i++] = tmp;
            }

        }

    }
}