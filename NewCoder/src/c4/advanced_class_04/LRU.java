package c4.advanced_class_04;

import java.util.HashMap;
import java.util.Scanner;

public class LRU {

	public static class Node {
		public int value;
		public Node last;
		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public static class CacheList {
		private Node head;
		private Node tail;

		public CacheList() {
			this.head = null;
			this.tail = null;
		}

		public void addNode(Node newNode) {
			if (newNode == null) {
				return;
			}
			if (this.head == null) {
				this.head = newNode;
				this.tail = newNode;
			} else {
				this.tail.next = newNode;
				newNode.last = this.tail;
				this.tail = newNode;
			}
		}

		public void moveNodeToTail(Node node) {
			if (this.tail == node) {
				return;
			}
			if (this.head == node) {
				this.head = node.next;
				this.head.last = null;
			} else {
				node.last.next = node.next;
				node.next.last = node.last;
			}
			node.last = this.tail;
			node.next = null;
			this.tail.next = node;
			this.tail = node;
		}

		public Node removeHead() {
			if (this.head == null) {
				return null;
			}
			Node res = this.head;
			if (this.head == this.tail) {
				this.head = null;
				this.tail = null;
			} else {
				this.head = res.next;
				res.next = null;
				this.head.last = null;
			}
			return res;
		}

	}

	public static class LRUCache {
		private HashMap<Integer, Node> keyNodeMap;
		private HashMap<Node, Integer> nodeKeyMap;
		private CacheList nodeList;
		private int capacity;

		public LRUCache(int capacity) {
			if (capacity < 1) {
				throw new RuntimeException("should be more than 0.");
			}
			this.keyNodeMap = new HashMap<Integer, Node>();
			this.nodeKeyMap = new HashMap<Node, Integer>();
			this.nodeList = new CacheList();
			this.capacity = capacity;
		}

		public int get(Integer key) {
			if (this.keyNodeMap.containsKey(key)) {
				Node res = this.keyNodeMap.get(key);
				this.nodeList.moveNodeToTail(res);
				return res.value;
			}
			return -1;
		}

		public void set(int key, int value) {
			if (this.keyNodeMap.containsKey(key)) {
				Node node = this.keyNodeMap.get(key);
				node.value = value;
				this.nodeList.moveNodeToTail(node);
			} else {
				Node newNode = new Node(value);
				this.keyNodeMap.put(key, newNode);
				this.nodeKeyMap.put(newNode, key);
				this.nodeList.addNode(newNode);
				if (this.keyNodeMap.size() == this.capacity + 1) {
					this.removeMostUnusedCache();
				}
			}
		}

		private void removeMostUnusedCache() {
			Node removeNode = this.nodeList.removeHead();
			Integer removeKey = this.nodeKeyMap.get(removeNode);
			this.nodeKeyMap.remove(removeNode);
			this.keyNodeMap.remove(removeKey);
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strs = str.split(" ");
		if(strs[0] == "p"){

		}

		LRUCache testCache = new LRUCache(3);
		testCache.set(1, 1);
		testCache.set(2, 2);
		testCache.set(3, 3);
		System.out.println(testCache.get(2));
		System.out.println(testCache.get(1));
		testCache.set(4, 4);
		System.out.println(testCache.get(4));
		System.out.println(testCache.get(3));

	}

}
