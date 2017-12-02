package my.li.org;

import java.util.Scanner;

public class Solution {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int m,n;
        while (sc.hasNext()){
            m = sc.nextInt();
            n= sc.nextInt();
            System.out.println(cal(m,n));
        }
    }

    private static int cal(int m, int n) {
        if(m==0 || n==1){
            return 1;
        }
        if(n > m){
            return cal(m,m);
        }else {
            return cal(m-n,n)+cal(m,n-1);
        }

    }
}
