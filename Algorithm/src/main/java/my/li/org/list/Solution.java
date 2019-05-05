package my.li.org.list;

import my.li.org.binary.ListNode;

/**
 * Created by LICHENG on 2017/12/23.
 */


public class Solution {

    public static void main(String args[]) {

        String[] arr = {"0", "3", "/"};


//        System.out.println(maxPoints(array));
        ListNode root = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        root.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = c;


        System.out.println(hasCycle(root));

    }
    public static boolean hasCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next !=null){
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow){
                    return true;
                }
            }
            return false;

    }


    /**
     * 143. Reorder List
     * @param head
     */
    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = slow.next;
        if (pre != null && pre.next != null) {
            ListNode nex = pre.next;
            while (nex != null) {
                pre.next = nex.next;
                nex.next = slow.next;
                slow.next = nex;
                nex = pre.next;
            }
        }
        merge(head, slow);
    }

    public static void merge(ListNode head, ListNode slow) {
        ListNode p = head;
        ListNode q = slow.next;
        while (p != null && q != null) {
            slow.next = q.next;
            q.next = p.next;
            p.next = q;
            q = slow.next;
            p = p.next.next;
        }
    }
}
