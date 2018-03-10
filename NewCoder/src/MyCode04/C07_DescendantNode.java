package MyCode04;

/**
 * 下一个后继节点
 */

public class C07_DescendantNode {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getNextNode(Node node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static Node mygetNextNode(Node node) {
        if (node.parent != null && node.parent.left == node) {
            return node.parent;
        }
        if (node.parent == null) {
            return node.right;
        }
        while (node.parent != null && node.right == null) {
            node = node.parent;
        }
        return node.right;
    }


    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        System.out.println(test.value + " next: " + mygetNextNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        System.out.println(test.value + " next: " + mygetNextNode(test).value);

        test = head.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        System.out.println(test.value + " next: " + mygetNextNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        System.out.println(test.value + " next: " + mygetNextNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        System.out.println(test.value + " next: " + mygetNextNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        System.out.println(test.value + " next: " + mygetNextNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        System.out.println(test.value + " next: " + mygetNextNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        System.out.println(test.value + " next: " + mygetNextNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        System.out.println(test.value + " next: " + mygetNextNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getNextNode(test));
        System.out.println(test.value + " next: " + mygetNextNode(test).value);
    }

}