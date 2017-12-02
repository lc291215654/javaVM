package com.company;

/**
 * Created by licheng on 11/13/17.
 */
public class Outer {
    int  no;

    class Inner implements InterfaceA{}




    interface InterfaceA{}

    public static void main()

    {

        Outer instanceA= new Outer();

        InterfaceA interfaceA=instanceA.new Inner() ;//注意内部类实例产生的方法，new 外围类实例.内部类名() ，这样做的目的是为了保证内部类实例一定有外围类实例hook.

//        InterfaceA interfaceB=instanceA.new Outer();//又生成了一个内部类的实例，且也挂靠在了实例instanceA上。

    }

}