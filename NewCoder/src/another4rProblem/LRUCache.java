package another4rProblem;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by licheng on 10/8/18.
 */
public class LRUCache {
    HashMap<Integer, Integer> map;
    LinkedList list;
    int size = 0;

    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>(capacity);
        list = new LinkedList();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove((Object) key);
            list.add(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.size() < size) {
            if(map.containsKey(key)){
                list.remove((Object) key);
            }
            list.add(key);
            map.put(key, value);
        } else {
            if(map.containsKey(key)){
                list.remove((Object) key);
            }else {
                int popkey = (int) list.pop();
                map.remove(popkey);
            }
            list.add(key);
            map.put(key, value);
        }

    }

    public static void main(String arg[]) {

        LRUCache cache = new LRUCache(10);
        cache.put(10, 13);
        cache.put(3, 17);
        cache.put(6, 11);
        cache.put(10, 5);
        cache.put(9, 10);
        System.out.println(cache.get(13));
        cache.put(2, 19);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(5, 25);
        System.out.println(cache.get(8));
        cache.put(9, 22);
        cache.put(5, 5);
        cache.put(1, 30);
        System.out.println(cache.get(11));
        cache.put(9, 12);
        System.out.println(cache.get(7));
        System.out.println(cache.get(5));
        System.out.println(cache.get(8));
        System.out.println(cache.get(9));



        //        HashMap<Integer, Integer> map = new HashMap<>(4);
//        map.put(1,1);
//        System.out.println(map.size());
//        map.put(1,2);
//        System.out.println(map.size());
//        map.put(2,2);
//        System.out.println(map.size());
//        map.remove(1);
//        System.out.println(map.size());
//        map.put(2,3);
//        System.out.println(map.size());
//
//        LinkedList list = new LinkedList();
//        list.add(1);
//        list.add(2);
//        System.out.println(list.pop());
//        list.add(3);
//
//        System.out.println(list.remove((Object)3));
//        System.out.println(list.poll());



    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */