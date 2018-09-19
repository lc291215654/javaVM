package ProgrammingProblem.leetcode;

/**
 * Created by LICHENG on 2018/9/6.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Traver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        int[][] dis = new int[n + 1][n + 1];
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            dis[a][b] = 1;
            dis[b][a] = 1;
        }
        int[] visited = new int[n + 1];
        visited[1] = 1;
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> rets = new ArrayList<Integer>();
        int cur = 0;
        list.add(1);
        rets.add(cur);
        int index = 0;
        while (isContinue(visited)) {
            int tmp = list.get(index);
            cur = rets.get(index);
            for (int i = 1; i <= n; i++) {
                if (dis[tmp][i] == 1 && visited[i] == 0) {
                    list.add(i);
                    rets.add(cur + 1);
                    visited[i] = 1;
                }
            }
            index++;
        }

        for (int i = 1; i < rets.size() - 1; i++) {
            if (rets.get(i + 1) == rets.get(i)) {
                res += 2;
            } else res++;
        }
        res++;
        System.out.println(res);
    }

    static public boolean isContinue(int[] visited) {
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == 0)
                return true;
        }
        return false;
    }
}