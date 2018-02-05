package my.li.org.Sort;

import java.util.Arrays;

/**
 * Created by licheng on 12/6/17.
 * 大顶堆排序
 */
public class Heapsort {

    protected int A[];
    protected int heapsize;

    public Heapsort() {
    }

    public Heapsort(int A[]) {
        buildMaxHeap(A);
    }

    protected int parent(int i) {
        return (i - 1) / 2;
    }

    protected int leftChildren(int i) {
        return 2 * i + 1;
    }

    protected int rightChildren(int i) {
        return 2 * i + 2;
    }

    protected void maxHeapify(int i) {
        int l = leftChildren(i);
        int r = rightChildren(i);
        int largest = i;
        if (l <= heapsize - 1 && A[l] > A[i])
            largest = l;
        if (r <= heapsize - 1 && A[r] > A[largest])
            largest = r;
        if (largest != i) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            this.maxHeapify(largest);
        }
    }

    public void buildMaxHeap(int[] A) {
        this.A = A;
        this.heapsize = A.length;
        for (int i = parent(heapsize - 1); i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public void heapsort(int[] A) {
        buildMaxHeap(A);
        int step = 1;
        /**
         * 将最大的元素即堆顶元素与最后一个元素交换，然后对剩下的元素构建最大堆，依次操作，最大的元素就依次被放到最后
         */
        for (int i = A.length - 1; i > 0; i--) {
            int temp = A[i];
            A[i] = A[0];
            A[0] = temp;
            heapsize--;
            System.out.println("Step: " + (step++) + Arrays.toString(A));
            maxHeapify(0);
        }
    }

    public static void main(String[] args) {
        //a sample input
        int[] A = {3, 7, 2, 11, 3, 4, 9, 2, 18, 0};
        System.out.println("Input: " + Arrays.toString(A));
        Heapsort maxhp = new Heapsort();
        maxhp.heapsort(A);
        System.out.println("Output: " + Arrays.toString(A));

    }
}
