package niuke;

/**
 * Created by licheng on 12/5/17.
 */

public class MaxSum {

    public static void main(String args[]){
        System.out.println(getMaxSum(new int[]{-1,-3,-2},3));
    }



    public static int getMaxSum(int[] A, int n) {
        int sum = 0;
        int max = -(1 << 30);
        System.out.println(max);
        for(int i=0;i<n;i++)
        {
            sum += A[i];
            if(sum > max)
            {
                max = sum;
            }
            if(sum < 0)
            {
                sum = 0;
            }
        }
        return max;
    }
}

//    // write code here
//    int sum = A[0];
//    int max = A[0];
//        for(int i=1;i<n;i++)
//        {
//        sum += A[i];
//        if(sum < A[i])
//        {
//        sum = A[i];
//        }
//        if(sum > max)
//        {
//        max = sum;
//        }
//        }
//        return max;