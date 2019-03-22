package another4rProblem;

public class Problem9 {
    static class Solution {
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