package com.alkapa.leetcode;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class A_002_AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1, t2 = l2, res = null, i = null;
        
        while (t1 != null || t2 != null) {
            int v1 = t1 != null ? t1.val : 0;
            int v2 = t2 != null ? t2.val : 0;

            if (res == null) {
                res = new ListNode(v1 + v2);
                i = res;
            } else {
                i.next = new ListNode(i.val / 10 + v1 + v2);
                i.val = i.val % 10;
                i = i.next;
            }

            t1 = t1 != null ? t1.next : null;
            t2 = t2 != null ? t2.next : null;
        }
        if (i.val > 9) {
            i.next = new ListNode(i.val / 10);
            i.val = i.val % 10;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);

        ListNode l3 = addTwoNumbers(l1, l2);

        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}