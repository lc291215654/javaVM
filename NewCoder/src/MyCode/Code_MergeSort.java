package MyCode;

import utils.RandomArray;

/**
 * Created by licheng on 2/5/18.
 */
public class Code_MergeSort {

    public static void main(String args[]) {
        int[] arr = new int[]{5, 3, 2, 8, 4, 7, 9};
//        int[] arr = new int[]{5,7,4,3,8};
        mergeSort(arr);
        RandomArray.printArray(arr);
    }

    public static void swap(int[] arr, int l, int r) {
        if (r == l) {
            return;
        }
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(arr, left, right);
        mergeSort(arr,left,mid-1);
        mergeSort(arr,mid+1,right);

    }

    public static int partition(int[] arr, int left, int right) {
        int k = arr[left];
        while (left < right) {
            while (arr[right] >= k && right > left) {
                right--;
            }
            swap(arr, right, left);
            while (arr[left] <= k && right > left) {
                left++;
            }
            swap(arr, right, left);
        }

        return left;


    }

}
