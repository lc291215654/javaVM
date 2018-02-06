import java.util.*;

/**
 * Created by licheng on 2/1/18.
 */


public class Lianshou {

    public static void main(String args[]) {


        Map<String,String> map = new IdentityHashMap<String, String>(100);

        String a = "aa";
        String b = new String("aa");


        System.out.println(a == b);
        System.out.println(a.equals(b));

        String n = "I Love Java";
        String m = new String("I Love Java");
        System.out.println(n==m);



//        Collections.nCopies()
    }
}
