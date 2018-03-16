import java.util.*;

/**
 * Created by licheng on 2/1/18.
 */

class Snow {
    Powder powder = new Powder();
}

class Powder extends Snow {
}

class Light extends Powder {
}

public class Lianshou {

    public static void main(String args[]) {

        HashMap<String,String> hashMap = new HashMap<String, String>();

        hashMap.put("xiaoli","apple");
        hashMap.put("xiaogao","orange");
        hashMap.put("xiaozou","apple");

        Set<String> keyset = hashMap.keySet();

        Collection<String> values = hashMap.values();





        System.out.println(hashMap);
        System.out.println(keyset);
        System.out.println(values);



    }

}
