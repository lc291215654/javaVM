package basic_class_05;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// undirected graph only
public class Code_06_Prim {

	public static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}

	}

	public static Set<Edge> primMST(Graph graph) {
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>(new EdgeComparator());
		HashSet<Node> set = new HashSet<Node>();
		Set<Edge> result = new HashSet<Edge>();
		for (Node node : graph.nodes.values()) {
			if (!set.contains(node)) {
				set.add(node);
				for (Edge edge : node.edges) {
					priorityQueue.add(edge);
				}
				while (!priorityQueue.isEmpty()) {
					Edge edge = priorityQueue.poll();
					Node toNode = edge.to;
					if (!set.contains(toNode)) {
						set.add(toNode);
						result.add(edge);
						for (Edge nextEdge : node.edges) {
							priorityQueue.add(nextEdge);
						}
					}
				}
			}
		}
		return result;
	}

}
