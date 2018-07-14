package ProgrammingProblem;

/**
 * Created by licheng on 7/14/18.
 */
public class CList {
    public int size;
    public Node node = null;

    public static class Node {
        public int value;
        public Node pre;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public void insert(Node node) {
        if (node == null) {
            return;
        }
        if (this.node == null) {
            this.node = node;
            this.node.pre = node;
            this.node.next = node;
            return;
        }
        Node tmp = node;
        this.node.pre.next = node;
        node.pre = this.node.pre;
        node.next = this.node;



    }

    public int size() {
        return size;
    }

    public Node remove(Node node) {
        return null;
    }
}
