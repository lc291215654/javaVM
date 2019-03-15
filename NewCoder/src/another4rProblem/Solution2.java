package another4rProblem;

import ProgrammingProblem.*;

import java.util.*;

/**
 * Created by LICHENG on 2018/10/10.
 */
public class Solution2 {

    class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[4];
        for(int i=0;i<4;i++){
            nums[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int k = 0;
        for(int i=1;i<=4;i++){
            stack.push(i);
            if(nums[k] == stack.peek()){
                stack.pop();
                k++;
            }
        }
        while (k<4){
            if(nums[k] != stack.pop()){
                break;
            }
            k++;
        }
        System.out.println(stack.isEmpty()?"YES":"NO");

    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return node;
        }
        Map<Integer,UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(root.label,root);
        queue.offer(node);
        while (!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            for(UndirectedGraphNode eachNode : cur.neighbors){
                if(!map.containsKey(eachNode.label)){
                    map.put(eachNode.label,new UndirectedGraphNode(eachNode.label));
                    queue.offer(eachNode);
                }
                map.get(cur.label).neighbors.add(map.get(eachNode.label));
            }
        }
        return root;
    }

    public int superEcggDrop(int K, int N) {
        int lo = 1, hi = N;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (f(mi, K, N) < N)
                lo = mi + 1;
            else
                hi = mi;
        }

        return lo;
    }

    public int f(int x, int K, int N) {
        int ans = 0, r = 1;
        for (int i = 1; i <= K; ++i) {
            r *= x-i+1;
            r /= i;
            ans += r;
            if (ans >= N) break;
        }
        return ans;
    }
}
