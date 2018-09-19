package MyCode.MyCode01;

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
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] mergearr = new int[(right - left)+1];

        int i = left;
        int j = mid+1;
        int index = 0;
        while (i <=mid && j <= right){
                mergearr[index++] = arr[i] > arr[j] ? arr[j++]:arr[i++];
        }
        while (i<=mid){
            mergearr[index++] = arr[i++];
        }

        while (j<=right){
            mergearr[index++] = arr[j++];
        }

        for(int k=0;k<mergearr.length;k++){
            arr[left++] = mergearr[k];
        }
    }

}
