package org.javaio;

/**
 * Created by LICHENG on 2018/6/18.
 */
public abstract class EnumTest<T extends EnumTest<T>> {
    abstract  T getT(T t);
}
