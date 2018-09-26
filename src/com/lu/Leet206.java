package com.lu;

import com.lu.util.ListNode;

public class Leet206 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = head, prev = null, p = head.next;
        newHead.next = null;
        while(p != null){
            prev = p;
            p = p.next;
            prev.next = newHead;
            newHead = prev;
        }
        return newHead;
    }


    public static void main(String[] args){
        Leet206 l206 = new Leet206();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        l206.reverseList(head);
    }
}
