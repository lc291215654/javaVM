package MyCode01;

import utils.RandomArray;

/**
 * Created by licheng on 2/5/18.
 */
public class C03_HeapSort {

    public static void main(String args[]) {
        int[] arr = new int[]{3, 5, 2, 8, 4, 7, 9, 3, 8, 5};
//        heapSort(arr);
        RandomArray.printArray(arr);
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}



















//
//    public static void heapSort(int[] arr) {
//        if(arr == null || arr.length <= 1){
//            return;
//        }
//        int size = arr.length;
//        for (int i = 0; i < size; i++) {
//            heapInsert(arr, i);
//        }
//        swap(arr, 0, --size);
//        while (size > 0) {
//            heapify(arr, 0, size);
//            swap(arr, 0, --size);
//        }
//    }
//
//    public static void heapInsert(int[] arr, int index) {
//        while (arr[index] > arr[(index - 1) / 2]) {
//            swap(arr, index, (index - 1) / 2);
//            index = (index - 1) / 2;
//        }
//    }
//
//    public static void heapify(int[] arr, int index, int size) {
//        int left = index * 2 + 1;
//        while (left < size) {
//            left = left + 1 < size && arr[left] < arr[left + 1] ? left + 1 : left;
//            if (arr[left] <= arr[(left - 1) / 2]) {
//                break;
//            }
//            swap(arr, left, (left - 1) / 2);
//            left = left * 2 + 1;
//        }
//    }