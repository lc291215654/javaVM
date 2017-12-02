package com.example.tutorial;

/**
 * Created by licheng on 11/30/17.
 */
public class BinarySearch {
    static public void main(String[] argv) {
       int A[] = {1,3,5,7,9,10,14};
        int i = getPos(A,7,10);

        System.out.println(i);
    }



    public static int getPos(int[] A, int n, int val) {

        int i = n - 1;
        int j = 0;
        int mid = (i + j) / 2;

        while (i > j) {
            if (A[mid] == val) {
                return mid;
            } else if (A[mid] < val) {
                j = mid;
                mid = (i + j) / 2;
            } else if (A[mid] > val) {
                i = mid;
                mid = (i + j) / 2;
            }
        }
        return 0;
    }
}