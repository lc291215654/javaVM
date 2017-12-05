package my.li.org.Sort;

/**
 * Created by licheng on 12/5/17.
 * 插入排序
 * 平均O(n^2),最好O(n),最坏O(n^2);空间复杂度O(1);稳定;简单
 */
public class InsertionSort {
    public static void insertionSort(int[] a) {
        int tmp;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
        insertionSort(a);
        for (int i : a)
            System.out.print(i + " ");
    }
}
