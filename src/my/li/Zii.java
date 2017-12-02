package my.li;

/**
 * Created by licheng on 11/10/17.
 */
public class Zii extends Foo {

    @Override
    public void service(){
        System.out.println("-------Zii service----------");
    }

    @Override
    public int init(){
        System.out.println("-------Zii init----------");
        return 0;
    }


}
