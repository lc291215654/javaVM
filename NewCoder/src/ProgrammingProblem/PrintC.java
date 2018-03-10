package ProgrammingProblem;

import utils.RandomArray;

import java.util.Random;

/**
 * Created by licheng on 3/7/18.
 */
public class PrintC {
    public static void main(String args[]) {
        int[] arr = partition(new int[]{5,5,3,2,8,4,7,9},0,6,5);

        RandomArray.printArray(arr);
    }

    public static int[] partition(int[] arr, int l, int r, int p) {

        int less = l-1;
        int more = r+1;

        while(l < more){
            if(arr[l] < p){
                RandomArray.swap(arr,l,less+1);
                less++;
                l++;
            }else if(arr[l] > more){
                RandomArray.swap(arr,l,more-1);
                more--;
            }else {
                l++;
            }
        }


        return new int[]{less+1,more-1};

    }


    public static void printC2(String s, int n, int left, int right) {
        if (right >= n) {
            System.out.println(s);
            return;
        }
        if (left < n) {
            printC2(s + "(", n, left + 1, right);
        }
        if (right < left) {
            printC2(s + ")", n, left, right + 1);
        }
    }

    public static void printC(String s, int n, int i, int left, int p) {
        if (i >= 2 * n) {
            System.out.println(s);
            return;
        }
        if (left < n) {
            printC(s + "(", n, left + 1, i + 1, p+1);
        }
        if (p - 1 >= 0) {
            printC(s + ")", n, left, i + 1, p -1);
        }
    }

}
