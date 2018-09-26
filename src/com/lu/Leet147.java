package com.lu;

import com.lu.util.ListNode;

public class Leet147 {
    private ListNode insert(ListNode head, ListNode p){
        ListNode q = head, prev = null;
        while(q != null && q.val < p.val){
            prev = q;
            q = q.next;
        }
        ListNode node = new ListNode(p.val);
        if(prev == null){
            node.next = head;
            head = node;
        } else {
            node.next = prev.next;
            prev.next = node;
        }
        return head;
    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;
        ListNode result = new ListNode(head.val);
        ListNode p = head.next;
        while(p != null){
            result = insert(result, p);
            p = p.next;
        }
        return result;
    }

    public static void main(String[] args){
        Leet147 l147 = new Leet147();
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        ListNode result = l147.insertionSortList(node);
    }
}

