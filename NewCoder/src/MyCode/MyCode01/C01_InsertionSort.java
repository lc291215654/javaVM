package MyCode.MyCode01;

import utils.RandomArray;

/**
 * Created by licheng on 2/9/18.
 */
public class C01_InsertionSort {

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length ; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                    swap(arr, j, j - 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    public static void main(String args[]){
        int[] arr1 = new int[]{2,3,7,1,9,3,2,3,1,0,12,97,4623,234,5,6,54,74523,5234,345,3223,6,624,645,2435};
        insertionSort(arr1);
        RandomArray.printArray(arr1);
    }

}
