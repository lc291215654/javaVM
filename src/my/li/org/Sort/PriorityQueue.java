package my.li.org.Sort;

import java.util.Arrays;

/**
 * Created by licheng on 12/6/17.
 */
public class PriorityQueue extends MaxHeap {
    public PriorityQueue() {
        super();
    }

    public PriorityQueue(int[] A) {
        super(A);
    }

    public double maximum() {
        return A[0];
    }

    public int extractMax() {
        if (heapsize < 1)
            System.err.println("no element in the heap");
        int max = A[0];
        A[0] = A[heapsize - 1];
        heapsize--;
        this.maxHeapify(0);
        return max;
    }

    public void increaseKey(int i, int key) {
        if (key < A[i])
            System.err.println("new key should be greater than old one");

        A[i] = key;
        while (i > 0 && A[parent(i)] < A[i]) {
            int temp = A[i];
            A[i] = A[parent(i)];
            A[parent(i)] = temp;
            i = parent(i);
        }
    }

    public void insert(int key) {
        heapsize++;
        A[heapsize - 1] = Integer.MIN_VALUE;
        increaseKey(heapsize - 1, key);
    }

    public static void main(String[] args) {
        //a sample input
        int[] A = {3, 7, 2, 11, 3, 4, 9, 2, 18, 0};
        System.out.println("Input: " + Arrays.toString(A));
        PriorityQueue pq = new PriorityQueue();
        pq.buildMaxHeap(A);
        System.out.println("Output: " + Arrays.toString(A));
        pq.increaseKey(2, 100);
        System.out.println("Output: " + Arrays.toString(A));
        System.out.println("maximum extracted: " + pq.extractMax());
        pq.insert(33);
        System.out.println("Output: " + Arrays.toString(A));

    }
}
