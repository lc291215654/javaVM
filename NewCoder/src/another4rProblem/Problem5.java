package another4rProblem;

public class Problem5 {

    static class Solution {

        /**
         * 204. Count Primes
         *
         * @param n
         * @return
         */
        public int countPrimes(int n) {
            boolean[] isPrime = new boolean[n + 1];
            for (int i = 2; i < n; i++) {
                isPrime[i] = true;
            }
            for (int i = 2; i * i < n; i++) {
                if (isPrime[i]) {
                    for (int j = i + i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime[i]) {
                    count++;
                }
            }
            return count;
        }

        /**
         * 231. Power of Two
         *
         * @param n
         * @return
         */
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) return false;
            return (n & (n - 1)) == 0;
        }

    }
}