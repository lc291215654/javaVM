package my.li.org;

/**
 * Created by LICHENG on 2017/12/27.
 */


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static HashMap<Grid, Boolean> visited = new HashMap<Grid, Boolean>();
    static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] ch = new char[10][10];
        int size = bfs();
        System.out.println(size);

    }

    public static int bfs() {
        Queue<Grid> queue = new LinkedList<Grid>();
        queue.add(new Grid(0, 0));
        int size = 1;
        while (!queue.isEmpty()) {
            Grid current = queue.poll();
            for (int i = 0; i < 4; i++) {
                Grid next = new Grid(current.x + direction[i][0], current.y + direction[i][1]);
                if (move(i) && !visited.containsKey(next) {
                    size++;
                    queue.add(next);
                    visited.put(next, true);
                }
            }
        }
        return size;
    }
}


class Grid {
    public int x;
    public int y;

    public Grid() {

    }

    public Grid(int x, int y) {
        this(x, y, 0);
    }

    public Grid(int x, int y, int step) {
        this.x = x;
        this.y = y;
    }

}
