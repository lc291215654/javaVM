package org.javaio;

/**
 * Created by LICHENG on 2018/6/16.
 */
public class IntA {

    public enum DAY {
        SUNDAY("a"), MOUDAY("b"), TUESDAY("c");
        private String doThing;

        DAY(){

        }

        DAY(String str) {
            doThing = str;
        }
    }

    ;

    static class Inner {
        void ff() {
            System.out.println(i);
        }


        public int i = 9;

    }

    public static void main(String args[]) {
        Inner inner = new Inner();

        DAY a = DAY.valueOf("MOUDAY");
        System.out.println(a.name());


    }


    int a = 1;


}
