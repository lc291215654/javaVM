package org.licheng.generic;

public interface IBase<E,T extends IDao> {
    T getDao();
    E getiDao();
    void setiDao(E e);
}
