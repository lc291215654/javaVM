package basic_class_07;

public class Code_02_Hanoi {

    public static void hanoi(int n) {
        if (n > 0) {
            func(n, "left", "right", "mid");
        }
    }


    /**
     * 把1到n彻底从from移动到to上去，可以借助help杆
     *
     * @param n
     * @param from
     * @param help
     * @param help
     */
    public static void func(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println("move 1 from " + from + " to " + to);
        } else {
            func(n - 1, from, help, to);
            System.out.println("move " + n + " from " + from + " to " + to);
            func(n - 1, help, to, from);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }

}
