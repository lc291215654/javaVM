package my.li.org.binary;

/**
 * Created by licheng on 12/3/17.
 */
public class LCA {
    public static int getLCA(int a, int b) {
        int result = 0;
        while(a != b){
            if(a > b){
                a = a/2;
            } else {
                b= b/2;
            }
        }
        return b;
    }
    public static void main(String args[]) {
        System.out.println(getLCA(8,7));
    }



}
