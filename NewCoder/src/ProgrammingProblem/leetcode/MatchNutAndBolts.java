package ProgrammingProblem.leetcode;

/**
 * Created by licheng on 8/30/18.
 */
public class MatchNutAndBolts {
    public static void main(String args[]) {
        int[] A = new int[]{ 5, 9, 3, 7, 1, 8, 2, 4, 6 };
        int[] B = new int[]{ 7, 4, 1, 2, 5, 6, 9, 8, 3 };
        MatchNutAndBolts ma = new MatchNutAndBolts();
        ma.match(A,B,0,A.length-1);
//        ma.sort(A,0,A.length-1);

        System.out.println();

    }

    public void sort(int[] A,int left,int right){
        if(left >= right){
            return;
        }
        int i = partition(A,A[left],left,right);
        sort(A,left,i-1);
        sort(A,i+1,right);
    }

    public void match(int[] A, int[] B, int left, int right) {
        if(left >= right){
            return;
        }
        int i = partition(B, A[left], left, right);
        partition(A, B[i], left, right);
        match(A, B, left, i - 1);
        match(A, B, i + 1, right);
    }

    public int partition(int[] arr, int k, int left, int right) {
        int i = left, j = right;
        while (i < j) {
            while (i < j && arr[i] < k) {
                i++;
            }
            while (i < j && arr[j] > k) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
