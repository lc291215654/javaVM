package MyCode03;

import java.util.HashMap;

/**
 * getRandom()等概率返回结构中的任何一个key
 * 解决方法在于删除一个key时，保证计数的连续性
 */
public class C06_RandomPool {

    public static class Pool<K> {
        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        private int size;

        public Pool() {
            keyIndexMap = new HashMap<K, Integer>();
            indexKeyMap = new HashMap<Integer, K>();
            size = 0;
        }

        public void insert(K key) {
            keyIndexMap.put(key, size);
            indexKeyMap.put(size, key);
            size++;
        }

        public void delete(K key) {
            int deleteindex = keyIndexMap.get(key);
            K lastkey = indexKeyMap.get(size-1);
            keyIndexMap.put(lastkey,deleteindex);
            indexKeyMap.put(deleteindex,lastkey);
            keyIndexMap.remove(key);
            indexKeyMap.remove(size);
            size--;
        }

        public K getRandom() {
            int index = (int) (Math.random() * size);
            return indexKeyMap.get(index);
        }

    }

    public static void main(String[] args) {

        Pool<String> pool = new Pool<String>();
        pool.insert("li");
        pool.insert("liu");
        pool.insert("zhang");
        pool.insert("wang");
        pool.insert("chen");
        pool.insert("chen");

        pool.delete("zhang");
        pool.delete("wang");
        pool.insert("zhang");
        pool.insert("wang");
        int i = 0, j = 0, k = 0, m = 0, n = 0;
        int times = 0;
        for (int size = 0; size < 10000; size++) {
            String key = pool.getRandom();
            if (key == "li") {
                i++;
                times = i;
            } else if (key == "liu") {
                j++;
                times = j;
            } else if (key == "zhang") {
                k++;
                times = k;
            } else if (key == "wang") {
                m++;
                times = m;
            } else {
                n++;
                times = n;
            }
            System.out.println(key + "::" +times);

        }
    }
}


