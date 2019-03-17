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
        
        Properties props = System.getProperties();

        Set<Object> keyset = props.keySet();
        for(Object key:keyset){
            System.out.println("key:" + key + "value:" + props.getProperty(key.toString()));
        }
    }

}
