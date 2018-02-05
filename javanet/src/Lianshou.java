import java.util.HashMap;

/**
 * Created by licheng on 2/1/18.
 */
public class Lianshou {

    public static boolean isHuiA(long n) {
        long help = 1;
        while (n / help >= 10) {
            help = help * 10;
        }

        while (n != 0) {
            if (n / help != n % 10) {
                return false;
            }
            n = (n % help) / 10;
            help = help / 100;
        }
        return true;
    }

    public static boolean isHuiB(String n) {

        char[] nstr = n.toCharArray();
        for (int i = 0; i < nstr.length / 2; i++){
            if(nstr[i] != nstr[nstr.length -(i+1)]){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        long la = System.currentTimeMillis();
        for(int i = 0; i< 10000000;i++) {
            isHuiA(91911211919l);
        }
        System.out.println(System.currentTimeMillis()-la);

        long lb = System.currentTimeMillis();
        for(int i = 0; i< 10000000;i++) {
            isHuiB("91911211919");
        }
        System.out.println(System.currentTimeMillis()-lb);
    }

    HashMap

    String string


}
