package ProgrammingProblem;

import java.util.Scanner;

/**
 * Created by licheng on 3/4/18.
 */
public class DictionarySort {


    /**
     * 以pre开头的树的小于n的节点个数
     *
     * @param pre
     * @param n
     * @return
     */
    public static long getCntOfPre(long pre, long n) {
        long cnt = 1;
        long p = 10;
        for (; pre * p <= n; p *= 10) {
            //该层最后一个数小于n
            if (pre * p - 1 + p < n) {
                cnt += p;
            } else {
                cnt += n - pre * p + 1;
            }
        }
        return cnt;
    }

    public static long solve(long n, long m) {
        if (n < m) {
            return -1;
        }
        long pre = 1;
        while (m != 0) {
            long cnt = getCntOfPre(pre, n);
            if (cnt >= m) {
                m--;
                if (m == 0) {
                    break;
                }
                pre *= 10;
            } else {
                m -= cnt;
                pre++;
            }
        }
        return pre;
    }

    public static class TrieNode {
        public int path;
        public int end;
        public TrieNode[] map;

        public TrieNode() {
            path = 0;
            end = 0;
            map = new TrieNode[10];
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - '0';
                if (node.map[index] == null) {
                    node.map[index] = new TrieNode();
                }
                node = node.map[index];
                node.path++;
            }
            node.end++;
        }

        public void delete(String word) {
            if (search(word)) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - '0';
                    node.map[index].path--;
                    if (node.map[index].path == 0) {
                        node.map[index] = null;
                        return;
                    }
                    node = node.map[index];
                }
                node.end--;
            }
        }

        public boolean search(String word) {
            if (word == null) {
                return false;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - '0';
                if (node.map[index] == null) {
                    return false;
                }
                node = node.map[index];
            }
            return node.end != 0;

        }

        public int prefixNumber(String pre) {
            if(pre == null){
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(int i=0;i<chs.length;i++){
                index = chs[i] - '0';
                if(node.map[index] == null){
                    return 0;
                }
                node = node.map[index];
            }
            return node.path;
        }


        }

        public static void main(String args[]) {
            Scanner in = new Scanner(System.in);
//        long n = in.nextLong();
//        long m = in.nextLong();

            System.out.println(solve(223, 148));
//            System.out.println(getCntOfPre(1, 11));

        }

    }
