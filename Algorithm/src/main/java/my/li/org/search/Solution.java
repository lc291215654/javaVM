package my.li.org.search;

import java.util.Stack;

/**
 * Created by LICHENG on 2017/12/23.
 */

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

public class Solution {

    public static void main(String args[]) {

        String[] arr = {"0", "3", "/"};
        Point[] array = new Point[3];


        System.out.println(maxPoints(array));

    }

    public static int maxPoints(Point[] points) {
        return 0;

    }
}
