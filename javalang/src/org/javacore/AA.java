package org.javacore;

/**
 * Created by licheng on 6/20/18.
 */
public class AA {
    void A(){
        B();
    }
    void B(){
        System.out.println("AA:" + "B");
    }

    public static void main(String args[]){
//        AA a = new BB();

        String aa = null;
        System.out.println(aa);
        System.out.println("");
//        a.A();

    }

}

class BB extends AA{

    @Override
    void B() {
        System.out.println("BB:" + "B");
    }
}
