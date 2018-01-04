package my.li.org;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by LICHENG on 2017/12/17.
 */
public class MaxInWindows {

    public static void main(String args[]) {

        int[] sequence = {5, 7, 6, 9, 12, 11, 8};
        maxInWindows(sequence,3);


    }


    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) {
            return res;
        }
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            if (q.isEmpty()) {
                q.add(i);
            } else if (begin > q.peekFirst()) {
                q.pollFirst();
            }

//            while ((!q.isEmpty()) && num[q.peekLast()] <= num[i]) {
//                q.pollLast();
//            }

            while ((!q.isEmpty()) && num[q.peekFirst()] <= num[i]) {
                q.pollFirst();
            }
            q.add(i);
            if (begin >= 0) {
                res.add(num[q.peekFirst()]);
            }
        }
        return res;
    }
}
