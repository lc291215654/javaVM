package MyCode04;

import java.util.Stack;

/**
 * 二叉树的前序/中序/后序遍历
 */
public class C05_PreInPostTraversal {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;

        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    public static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    public static void preOrderUnRecur(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public static void inOrderUnRecur(Node head) {
        System.out.print("in-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecur1(Node head) {
        System.out.print("pos-order: ");
        if (head != null) {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().value + " ");
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecur2(Node h) {
        System.out.print("pos-order: ");
        if (h != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(h);
            Node cur = null;
            while (!stack.isEmpty()) {
                cur = stack.peek();
                if (cur.left != null && h != cur.left && h != cur.right) {
                    stack.push(cur.left);
                } else if (cur.right != null && h != cur.right) {
                    stack.push(cur.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    h = cur;
                }
            }
        }
        System.out.println();
    }

    public static void myinOrderUnRecur(Node head) {
        System.out.print("my-in--order: ");
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.value);
                head = head.right;
            }
        }
    }

    public static void mypostOrderUnRecur(Node head) {
        System.out.println("my-post--order: ");
        if (head == null) {
            return;
        }
        Node pre = head;
        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.peek();
            if (((head.right == null)&&(head.left ==pre)) || head.right == pre || ((head.left==null)&&(head.right==null))) {
                System.out.print(head.value + " ");
                stack.pop();
                pre = head;
            } else {
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }

        System.out.println("my-post--order: ");
    }

    public static void mypostOrderUnRecur2(Node head) {
        System.out.println("my-post--order2: ");
        if (head == null) {
            return;
        }
        Node pre = head;
        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            if(!stack.isEmpty() && head == stack.peek()){
                if(head.right != null){
                    stack.push(head.right);
                    stack.push(head.right);
                }
                if(head.left != null){
                    stack.push(head.left);
                    stack.push(head.left);
                }
            }else {
                System.out.print(head.value + " ");
            }
        }
        System.out.println();
        System.out.println("my-post--order2: ");
    }


    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
//        System.out.println("==============recursive==============");
//        System.out.print("pre-order: ");
//        preOrderRecur(head);
//        System.out.println();
//        System.out.print("in-order: ");
//        inOrderRecur(head);
//        System.out.println();
//        System.out.print("pos-order: ");
//        posOrderRecur(head);
//        System.out.println();
//
//        System.out.println("============unrecursive=============");
//        preOrderUnRecur(head);
//
//        inOrderUnRecur(head);
//        myinOrderUnRecur(head);
//        mypostOrderUnRecur(head);
        mypostOrderUnRecur2(head);
        posOrderUnRecur1(head);
        posOrderUnRecur2(head);


    }

}
