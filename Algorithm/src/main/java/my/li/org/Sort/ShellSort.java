package my.li.org.Sort;

import java.util.Arrays;

/**
 * Created by licheng on 12/5/17.
 * 这个代码写的是shell排序，其实我个人认为这个排序的思想是把归并和快排的思想结合起来，快排是通过
 * 第一个元素来进行左右划分，归并是无论什么样，先将数组分成两组，然后继续分最后结合起来，这个shell排序，首先是将数组
 * 分为两组，然后进行插入，其实就类似将大的或者小的先放在前面或者后面
 */
public class ShellSort {

    private static void shellSort(int[] a) {
        // 将数组分组
        for (int r = a.length / 2; r >= 1; r /= 2) {
            // 这里的思路和插入排序的思路相同，通过找到前一个的数大于或者小于来进行插入
            for (int i = 0; i < r; i++) {
                for (int j = i; j < a.length; j += r) {
                    for (int k = j; k - r >= 0; k -= r) {
                        if (a[k] < a[k - r]) {
                            int tmp = a[k - r];
                            a[k - r] = a[k];
                            a[k] = tmp;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 2, 0, 8, 6, 4, 6, 4, 2, 0, 8, 6, 4, 6};
        shellSort(a);
        // 输出排序后的数组
        System.out.println(Arrays.toString(a));
    }
}