package niuke;

/**
 * Created by licheng on 12/5/17.
 */
public class Queens {

    public Queens() {

    }

    public static void main(String arg[]) {
        Queens queens = new Queens();

        System.out.println(queens.nQueens(2));
    }

    public int nQueens(int n) {
        // write code here
        Queens queens = new Queens(n);
        queens.Queens1(1);
        return count;
    }

    public static int n; //n是皇后个数
    public static int count; //解个数
    public static int[] A;

    public Queens(int n) {
        this.n = n;
        count = 0;
        A = new int[n + 1];
    }

    static void Queens1(int i) {
        if (i > n) {
//            for (int j = 1; j <= n; j++) {
//                for (int k = 1; k <= n; k++) {
//                    if (A[j] == k) {
//                        System.out.print("#");
//                    } else {
//                        System.out.print("-");
//                    }
//                }
//                System.out.println();
//            }
//            System.out.println("       ");
            count++;
            return;
        }
        //第i行遍历所有节点
        for (int j = 1; j <= n; j++) {
            A[i] = j;
            if (Place(i) == 1) {
                Queens1(i + 1);
            }
        }
    }

    //第i行，第a[i]列是否可以放置皇后
    static int Place(int i) {
        for (int j = 1; j < i; j++) {
            if ((A[j] == A[i])
                    || (A[j] - A[i] == (j - i))
                    || (A[j] - A[i] == (i - j))) {
                return 0;
            }
        }
        return 1;
    }
}
