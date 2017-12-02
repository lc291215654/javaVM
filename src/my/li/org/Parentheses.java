package my.li.org;

import java.util.ArrayList;

/**
 * Created by licheng on 11/30/17.
 */
public class Parentheses {

    public static void main(String args[]) {
        generate(2, 2, "");
    }

    public static int i = 1;

    public static void generate(int leftNum, int rightNum, String s) {
        if (leftNum == 0 && rightNum == 0) {
            System.out.println(s);
            System.out.println(i++);
        }
        if (leftNum > 0) {
            generate(leftNum - 1, rightNum, s + '(');
        }
        if (rightNum > 0 && leftNum < rightNum) {
            generate(leftNum, rightNum - 1, s + ')');
        }
    }
}
