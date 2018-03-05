package MyCode05;
import java.util.*;

/**
 * 拓扑排序
 *
 */

public class C04_TopologySort {

	// directed graph and no loop
	public static List<Node> sortedTopology(Graph graph) {
		HashMap<Node, Integer> inMap = new HashMap<Node, Integer>();
		Queue<Node> zeroInQueue = new LinkedList<Node>();

		for (Node node : graph.nodes.values()) {
			inMap.put(node, node.in);
			if (node.in == 0) {
				zeroInQueue.add(node);
			}
		}

		List<Node> result = new ArrayList<Node>();
		while (!zeroInQueue.isEmpty()) {
			Node cur = zeroInQueue.poll();
			result.add(cur);
			for (Node next : cur.nexts) {
				inMap.put(next, inMap.get(next) - 1);
				if (inMap.get(next) == 0) {
					zeroInQueue.add(next);
				}
			}
		}

		return result;
	}


	public static void main(String args[]){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.nexts.add(node3);
        node1.out++;
        node3.in++;

        node2.nexts.add(node3);
        node2.out++;
        node3.in++;

        node4.nexts.add(node6);
        node4.out++;
        node6.in++;

        node3.nexts.add(node5);
        node3.out++;
        node5.in++;

        node3.nexts.add(node6);
        node3.out++;
        node6.in++;

        node5.nexts.add(node7);
        node5.out++;
        node7.in++;

        node6.nexts.add(node7);
        node6.out++;
        node7.in++;

        Graph graph = new Graph();
        graph.nodes.put(1,node1);
        graph.nodes.put(2,node2);
        graph.nodes.put(3,node3);
        graph.nodes.put(4,node4);
        graph.nodes.put(5,node5);
        graph.nodes.put(6,node6);
        graph.nodes.put(7,node7);

        List<Node> list = sortedTopology(graph);

        for(Node node:list) {
            System.out.println(node.value);
        }


    }
}
