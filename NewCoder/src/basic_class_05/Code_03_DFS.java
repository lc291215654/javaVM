package basic_class_05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

/**
 * 深度优先遍历
 */
public class Code_03_DFS {

	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		HashSet<Node> set = new HashSet<Node>();
		stack.add(node);
		set.add(node);
		System.out.println(node.value);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
					stack.push(cur);
					stack.push(next);
					set.add(next);
					System.out.println(next.value);
					break;
				}
			}
		}
	}

	public static HashSet<Node> set = new HashSet<>();
	public static void recursive_dfs(Node node){
		System.out.println(node.value);
		set.add(node);
		for(Node next:node.nexts){
			if(!set.contains(next)) {
				recursive_dfs(next);
			}
		}
	}

	public static void main(String args[]){

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);

		node1.nexts.add(node2);
		node1.nexts.add(node3);
		node2.nexts.add(node4);
		node2.nexts.add(node5);
		node3.nexts.add(node6);
		node3.nexts.add(node7);

//		recursive_dfs(node1);
		dfs(node1);

	}

}
