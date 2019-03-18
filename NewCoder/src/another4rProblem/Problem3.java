package another4rProblem;

/**
 * Created by licheng on 10/12/18.
 */
public class Problem3 {

    public static void main(String[] args){
        String result = "     osdmap e468: 4 osds: 4 up, 4 in\\n            flags sortbitwise,require_jewel_osds\\n";

        System.out.println(result);
        System.out.println(result.indexOf("osdmap"));
        System.out.println(result.indexOf("\\n"));
        result = result.substring(result.indexOf("osdmap"),result.indexOf("n"));
        System.out.println(result);

    }



    static class Solution {

        /**
         * 191. Number of 1 Bits
         * @param n
         * @return
         */
        public int hammingWeight(int n) {
            int sum =0;
            while(n != 0){
                sum++;
                n = n & (n-1);
            }
            return sum;
        }

        /**
         * 461. Hamming Distance
         * @param x
         * @param y
         * @return
         */
        public int hammingDistance(int x, int y) {
            int n = x ^ y;
            int sum =0;
            while(n != 0){
                sum++;
                n = n & (n-1);
            }
            return sum;

        }
    }
}
