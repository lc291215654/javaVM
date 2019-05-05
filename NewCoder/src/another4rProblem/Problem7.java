package another4rProblem;

import java.util.Arrays;
import java.util.HashSet;

import java.util.*;

public class Problem7 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] da = new int[]{1, 1, 1, 2, 2, 3};
        solution.topKFrequent(da, 2);
        String[] das = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        solution.topKFrequent(das,3);
        System.out.println("aa");

    }

    static class Solution {


        /**
         * 349. Intersection of Two Arrays
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();

            for(int i=0;i < nums1.length ;i++){
                set1.add(nums1[i]);
            }
            for(int i = 0;i < nums2.length;i++){
                if(!set1.add(nums2[i])){
                    set2.add(nums2[i]);
                }
            }
            int[] re = new int[set2.size()];
            int i = 0;
            for(int k : set2){
                re[i++] = k;
            }
            return re;
        }



        public void reverseString(char[] s) {
            int i = 0;
            int j = s.length - 1;
            while (i < j){
                char tmp = s[j];
                s[j--] = s[i];
                s[i++] = tmp;
            }

        }

        public List<Integer> topKFrequent(int[] nums, int k) {
            List<Integer>[] bucket = new List[nums.length + 1];
            Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

            for (int n : nums) {
                frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
            }

            for (int key : frequencyMap.keySet()) {
                int frequency = frequencyMap.get(key);
                if (bucket[frequency] == null) {
                    bucket[frequency] = new ArrayList<>();
                }
                bucket[frequency].add(key);
            }

            List<Integer> res = new ArrayList<>();

            for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
                if (bucket[pos] != null) {
                    res.addAll(bucket[pos]);
                }
            }
            return res;
        }

        public List<Integer> topKFrequent2(int[] nums, int k) {
            // build hash map : character and how often it appears
            HashMap<Integer, Integer> count = new HashMap();
            for (int n: nums) {
                count.put(n, count.getOrDefault(n, 0) + 1);
            }
            // init heap 'the less frequent element first'
            PriorityQueue<Integer> heap =
                    new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));
            // keep k top frequent elements in the heap
            for (int n: count.keySet()) {
                heap.add(n);
                if (heap.size() > k)
                    heap.poll();
            }
            // build output list
            List<Integer> top_k = new LinkedList();
            while (!heap.isEmpty())
                top_k.add(heap.poll());
            Collections.reverse(top_k);
            return top_k;
        }

        public List<String> topKFrequent(String[] words, int k) {
            HashMap<String,Integer> count = new HashMap<>();
            for(String word:words){
                count.put(word,count.getOrDefault(word,0) + 1);
            }
            PriorityQueue<String> heap = new PriorityQueue<>((s1,s2) -> count.get(s1) - count.get(s2));
            for(String word:count.keySet()){
                heap.add(word);
                if(heap.size() > k){
                    heap.poll();
                }
            }

            List<String> top_k = new LinkedList<>();
            while(!heap.isEmpty()){
                top_k.add(heap.poll());
            }
            Collections.reverse(top_k);
            return top_k;
        }

    }
}