package org.javaconcurrent;

/**
 * Created by licheng on 5/3/18.
 */
public class Manager {
    public static void main(String args[]){
        I a = new AA();
        I b = new BB();
        Manager manager = new Manager();
        manager.doMyAction(b);
    }



    private void doMyAction(I i){
        i.eat();
    }
}
