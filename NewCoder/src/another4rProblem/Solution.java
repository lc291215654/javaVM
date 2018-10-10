package another4rProblem;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int X = sc.nextInt();
        int[] prices = new int[n];
        for(int i =0;i<n;i++){
            prices[i] = sc.nextInt();
        }
        int result = calHepler(prices,0,X,0);
        System.out.println(result);
    }

    private static int calHepler(int[] prices, int i, int X,int cur) {
        if(cur >= X){
            return cur;
        }
        if(i >= prices.length){
            return Integer.MAX_VALUE;
        }
        return Math.min(calHepler(prices,i+1,X,cur + prices[i]),
        calHepler(prices,i+1,X,cur));
    }

}
