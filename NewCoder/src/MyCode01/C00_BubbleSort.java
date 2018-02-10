package MyCode01;

import utils.RandomArray;

/**
 * Created by licheng on 2/9/18.
 */
public class C00_BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    public static void main(String args[]){
        int[] arr1 = new int[]{2,3,7,1,9,3,2,3,1,0,12};
        bubbleSort(arr1);
        RandomArray.printArray(arr1);
    }




}
