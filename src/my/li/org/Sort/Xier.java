package my.li.org.Sort;

import java.util.Arrays;

/**
 * Created by licheng on 12/5/17.
 */
public class Xier {
    public static void Shellsort(int[] arrays) {
        if (arrays == null || arrays.length <= 1) {
            return;
        }
        //增量
        int incrementNum = arrays.length / 2;
        while (incrementNum >= 1) {
            //incrementNum=1;
            for (int i = 0; i < arrays.length; i++) {
                //进行插入排序
                for (int j = i; j < arrays.length - incrementNum; j = j + incrementNum) {
                    if (arrays[j] > arrays[j + incrementNum]) {
                        int temple = arrays[j];
                        arrays[j] = arrays[j + incrementNum];
                        arrays[j + incrementNum] = temple;
                    }
                }
            }
            //设置新的增量
            incrementNum = incrementNum / 2;
            System.out.println(Arrays.toString(arrays));
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 2, 4, 2, 8, 0, 4, 2, 3, 6, 4, 6};
        Xier.Shellsort(a);
    }

}
