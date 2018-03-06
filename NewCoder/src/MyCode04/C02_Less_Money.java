package MyCode04;

import java.util.Comparator;
import java.util.PriorityQueue;

public class C02_Less_Money {

    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<Integer>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }

    public static class MinheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }

    }

    public static class MaxheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }

    }

    public static void main(String[] args) {
        // solution
        int[] arr = {6, 7, 8, 9};
        System.out.println(lessMoney(arr));

        int[] arrForHeap = {3, 5, 2, 7, 0, 1, 6, 4};
        System.out.println(lessMoney(arrForHeap));

        // min heap
        PriorityQueue<Integer> minQ1 = new PriorityQueue<Integer>();
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ1.add(arrForHeap[i]);
        }
        while (!minQ1.isEmpty()) {
            System.out.print(minQ1.poll() + " ");
        }
        System.out.println();
    }

}
