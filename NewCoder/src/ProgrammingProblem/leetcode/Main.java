package ProgrammingProblem.leetcode;

/**
 * Created by LICHENG on 2018/9/6.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //最终的答案
    int ans = Integer.MAX_VALUE;
    //visited[i]表示第i个地点被访问过
    boolean visited[];
    //存储全部地点
    Point[] a;
    //起点
    Point start = new Point(0, 0);

    //求两个点之间的距离
    int getDis(Point x, Point y) {
        return Math.abs(x.x - y.x) + Math.abs(x.y - y.y);
    }

    /**
     * 递归求解
     *
     * @param cur        当前所在位置
     * @param dis        当前已经走过的距离
     * @param visitCount 已经访问的城市个数，用来记录递归终点
     **/
    void go(Point cur, int dis, int visitCount) {
        if (visitCount == visited.length) {//如果已经访问完了，更新答案
            ans = Math.min(ans, dis + getDis(start, cur));
        }
        //利用到起点的距离剪枝
        if (dis > ans) {
            return;
        }
        //利用到终点的距离剪枝
        if (dis + getDis(cur, start) > ans) {
            return;
        }
        //对于每个未曾访问的城市进行处理
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                go(a[i], dis + getDis(cur, a[i]), visitCount + 1);
                visited[i] = false;
            }
        }
    }

    Main() {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        a = new Point[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int pos[] = Arrays.stream(cin.next().split(",")).mapToInt(Integer::parseInt).toArray();
            a[i] = new Point(pos[0], pos[1]);
        }
        go(new Point(0, 0), 0, 0);
        System.out.println(ans);
    }


    public static void main(String[] args) {
        new Main();
    }
}