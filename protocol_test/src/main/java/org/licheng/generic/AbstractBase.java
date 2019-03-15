package org.licheng.generic;

public abstract class AbstractBase<E,T extends IDao> implements IBase<E,T> {
    E dao;
    public E getiDao() {
        return dao;
    }
    public void setiDao(E e) {
        dao = e;
    }
}
