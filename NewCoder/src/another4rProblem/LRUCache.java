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
            map.put(key, value);
            list.add(key);
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

        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */