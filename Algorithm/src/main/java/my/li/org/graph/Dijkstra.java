package my.li.org.graph;

import java.util.Scanner;

/**
 * Created by licheng on 12/3/17.
 */
public class Dijkstra {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();

            // 初始化邻接矩阵
            int[][] Edge = new int[n + 1][n + 1];
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    Edge[i][j] = Integer.MAX_VALUE;
                }
            }
            // 输入邻接矩阵
            for (int i = 0; i < m; i++) {
                Edge[in.nextInt()][in.nextInt()] = in.nextInt();
            }
            Dijkstr(Edge, n);
        }
    }

    private static void Dijkstr(int[][] edge,int n) {
        // 到每个节点的最短路径长度
        int dist[] = new int[n + 1];
        // 最短路径中的前一个顶点号
        int path[] = new int[n + 1];
        // 顶点是否被确定了
        boolean isDetermined[] = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            dist[i] = edge[0][i];
            if (i != 0 && dist[i] < Integer.MAX_VALUE)
                path[i] = 0;
            else
                path[i] = -1;
        }
        // 开始对对一个站进行操作
        isDetermined[0] = true;
       // dist[0] = 0;
        // 从顶点v确定n条路径
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int u = 0;
            // 选择当前不在S中且到起始点距离最短的顶点u
            for (int j = 0; j < n + 1; j++) {
                if (!isDetermined[j] && dist[j] < min) {
                    u = j;
                    min = dist[j];
                }
            }
            // 表示u已经在最短路径上
            isDetermined[u] = true;
            for (int k = 0; k < n + 1; k++) {
                if (!isDetermined[k]
                        && edge[u][k] < Integer.MAX_VALUE
                        && dist[u] + edge[u][k] < dist[k]) {
                    dist[k] = dist[u] + edge[u][k];
                    path[k] = u;
                }
            }
        }
        System.out.println(dist[n-1] + "");
    }
}
