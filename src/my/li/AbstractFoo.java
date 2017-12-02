package my.li;

/**
 * Created by licheng on 11/10/17.
 */
public abstract class AbstractFoo implements Service {


    @Override
    public int init() {
        System.out.println("-------AbstractFoo init----------");
        return 0;
    }


}
