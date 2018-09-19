package MyCode.MyCode01;

import utils.RandomArray;

/**
 * Created by licheng on 2/9/18.
 */
public class C02_SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minindex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minindex]) {
                    minindex = j;
                }
            }
            swap(arr, i, minindex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String args[]) {
        int[] arr1 = new int[]{2, 3, 7, 1, 9, 3, 2, 3, 1, 0, 12, 97, 4623, 234, 5, 6, 54, 74523, 5234, 345, 3223, 6, 624, 645, 2435};
        selectionSort(arr1);
        RandomArray.printArray(arr1);
    }
}
