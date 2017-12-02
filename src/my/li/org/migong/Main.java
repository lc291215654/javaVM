package my.li.org.migong;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Migong {
    static boolean[][] visited;
    static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] ch = new char[10][10];
        while (in.hasNext()) {
            visited = new boolean[10][10];
            for (int i = 0; i < 10; i++) {
                char[] temp = in.nextLine().toCharArray();
                for (int j = 0; j < 10; j++) {
                    ch[i][j] = temp[j];
                }
            }
            Minode start = new Minode(0, 1, 0);
            Minode end = new Minode(9, 8, 0);
            bfs(ch, start, end);
        }
    }

    public static void bfs(char[][] ch, Minode start, Minode end) {
        LinkedList<Minode> queue = new LinkedList<Minode>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Minode current = queue.pollLast();
            if ((current.x == end.x) && (current.y == end.y)) {
                System.out.println(current.step);
                break;
            }
            for (int i = 0; i < 4; i++) {
                Minode next = new Minode(current.x + direction[i][0], current.y + direction[i][1], current.step + 1);
                if (next.x >= 0
                        && next.x < 10
                        && next.y + direction[i][1] >= 0
                        && next.y + direction[i][1] < 10
                        && ch[next.x][next.y] != '#'
                        && !visited[next.x][next.y]) {
                    queue.add(next);
                    visited[next.x][next.y] = true;
                }
            }
        }
    }
}


class Minode {
    public int x;
    public int y;
    public int step;

    public Minode(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }

}
