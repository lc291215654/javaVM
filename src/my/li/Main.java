//package my.li;
//
//import my.li.org.binary.TreeNode;
//
//import java.util.Scanner;
//import java.util.Stack;
//
///**
// * Created by licheng on 11/10/17.
// */
//public class Main {
//    public static void main(String args[]){
//    Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//        int m = in.nextInt();
//        int n = in.nextInt();
//        int dist[] = new int[n + 1];
//        int path[] = new int[n + 1];
//        boolean S[] = new boolean[n + 1];
//        int[][] Edge = new int[n + 1][n + 1];
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < n + 1; j++) {
//                Edge[i][j] = Integer.MAX_VALUE;
//            }
//        }
//        // 输入邻接矩阵
//        for (int i = 0; i < m; i++) {
//            Edge[in.nextInt()][in.nextInt()] = in.nextInt();
//        }
//        Dijkstr(Edge, dist, path, S, m, n);
//    }
//}
//    private static void Dijkstr(int[][] edge, int[] dist, int[] path, boolean[] s, int m, int n) {
//        for (int i = 0; i < n + 1; i++) {
//            dist[i] = edge[0][i];
//            if (i != 0 && dist[i] < Integer.MAX_VALUE)
//                path[i] = 0;
//            else
//                path[i] = -1;
//        }
//        // 开始对对一个站进行操作
//        s[0] = true;
//        dist[0] = 0;
//        // 从顶点v确定n条路径
//        for (int i = 0; i < n; i++) {
//            int min = Integer.MAX_VALUE, u = 0;
//            // 选择当前不在S中具有最短路径的顶点u
//            for (int j = 0; j < n + 1; j++) {
//                if (!s[j] && dist[j] < min) {
//                    u = j;
//                    min = dist[j];
//                }
//            }
//            // 表示u已经在最短路径上
//            s[u] = true;
//            for (int k = 0; k < n + 1; k++) {
//                if (!s[k] && edge[u][k] < Integer.MAX_VALUE && dist[u] + edge[u][k] < dist[k]) {
//                    dist[k] = dist[u] + edge[u][k];
//                    path[k] = u;
//                }
//            }
//        }
//        System.out.println(dist[n] + "");
//    }
//}
