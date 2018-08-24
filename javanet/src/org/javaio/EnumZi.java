package org.javaio;

/**
 * Created by LICHENG on 2018/6/18.
 */
public class EnumZi extends EnumTest<EnumZi> {
    @Override
    EnumZi getT(EnumZi enumZi ) {
        System.out.println(enumZi.getClass());
        return new EnumZi();
    }

    public static void main(String args[]){
        EnumZi a = new EnumZi();
        a.getT(a);
    }
}
