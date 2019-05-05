package another4rProblem;

import java.util.HashMap;
import java.util.Map;

public class Problem6 {


    public static void main(String[] args){
        Solution solution = new Solution();
        int re =solution.nthUglyNumber(10);
        System.out.println(re);
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
    }
}