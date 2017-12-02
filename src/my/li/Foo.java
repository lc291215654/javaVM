package my.li;

/**
 * Created by licheng on 11/10/17.
 */
public class Foo extends AbstractFoo {

    @Override
    public int init() {
        System.out.println("-------Foo init----------");
        service();
        return 0;
    }

    public void service(){
        System.out.println("-------Foo service----------");
    }
}
