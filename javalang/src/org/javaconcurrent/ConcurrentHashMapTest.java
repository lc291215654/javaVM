package org.javaconcurrent;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;

/**
 * Created by licheng on 3/14/18.
 */
public class ConcurrentHashMapTest {
    Hashtable<String,String> hashtable = new Hashtable<>();
    ConcurrentHashMap map = new ConcurrentHashMap();

}
