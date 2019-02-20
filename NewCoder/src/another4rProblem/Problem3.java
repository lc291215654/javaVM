package another4rProblem;

/**
 * Created by licheng on 10/12/18.
 */
public class Problem3 {

    public void main(String[] args){

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
