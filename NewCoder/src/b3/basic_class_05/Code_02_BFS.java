package b3.basic_class_05;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 宽度优先遍历
 */

public class Code_02_BFS {

	public static void bfs(Node node) {
		if (node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		HashSet<Node> set = new HashSet<Node>();
		queue.add(node);
		set.add(node);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.println(cur.value);
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
					set.add(next);
					queue.add(next);
				}
			}
		}
	}

}
