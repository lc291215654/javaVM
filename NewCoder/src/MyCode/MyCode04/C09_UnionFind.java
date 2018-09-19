package MyCode.MyCode04;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集
 */
public class C09_UnionFind {

	public static class Node {
		// whatever you like
		public int data ;
	}

	public static class DisjointSets {
		public HashMap<Node, Node> fatherMap;
		public HashMap<Node, Integer> rankMap;

		public DisjointSets() {
			fatherMap = new HashMap<Node, Node>();
			rankMap = new HashMap<Node, Integer>();
		}

		public void makeSets(List<Node> nodes) {
			fatherMap.clear();
			rankMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				rankMap.put(node, 1);
			}
		}

		public Node findFather(Node n) {
			Node father = fatherMap.get(n);
			//递归寻找并修改代表节点
			if (father != n) {
				father = findFather(father);
			}
			fatherMap.put(n, father);
			return father;
		}

		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aFather = findFather(a);
			Node bFather = findFather(b);
			if (aFather != bFather) {
				int aFatherRank = rankMap.get(aFather);
				int bFatherRank = rankMap.get(bFather);
				if (aFatherRank <= bFatherRank) {
					fatherMap.put(aFather, bFather);
					rankMap.put(bFather, aFatherRank + bFatherRank);
				} else {
					fatherMap.put(bFather, aFather);
					rankMap.put(aFather, aFatherRank + bFatherRank);
				}
			}
		}

	}

	public static void main(String[] args) {

	}

}
