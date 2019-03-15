package another4rProblem;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] curnum = new int[N];
        curnum[0] = M;
        int[] result = new int[1];
        calHepler(result,0,curnum);
        System.out.println(result[0] % 1000000007);
    }

    private static void calHepler(int[] result, int index, int[] curnums) {
        if(index >= curnums.length - 1){
            if((curnums[index - 1] % curnums[index]) == 0){
                result[0]++;
            }
            return ;
        }
        if(index > 0 && (curnums[index - 1] % curnums[index]) != 0){
            return ;
        }
        if(curnums[index] == 1){
            result[0]++;
            return ;
        }
        index++;
        for(int i=curnums[0];i>=1;i--) {
            curnums[index] = i;
            calHepler(result,index,curnums);
        }
    }

}
