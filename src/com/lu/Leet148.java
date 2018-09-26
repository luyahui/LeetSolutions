package com.lu;

import com.lu.util.ListNode;

import javax.swing.*;

public class Leet148 {
    private ListNode addNode(ListNode head, ListNode p){

        if(head == null)
            head = new ListNode(p.val);
        else{
            ListNode q = head;
            while(q.next != null)
                q = q.next;
            q.next = new ListNode(p.val);
        }
        return head;
    }

    public ListNode sortList(ListNode head) {
        if(head == null)
            return null;

        ListNode pivot = head;
        ListNode left = null, right = null;

        ListNode p = head.next;
        while(p != null){
            if(p.val <= pivot.val)
                left = addNode(left, p);
            else
                right = addNode(right, p);
            p = p.next;
        }
        ListNode smaller = sortList(left);
        ListNode larger = sortList(right);

        ListNode result = smaller;
        ListNode q = result, prev = null;
        while(q != null){
            prev = q;
            q = q.next;
        }

        if(prev == null){
            result = pivot;
        } else {
            prev.next = pivot;
        }
        pivot.next = larger;

        return result;
    }

    public static void main(String[] args){
        Leet148 l148 = new Leet148();
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
//        node.next.next = new ListNode(1);
//        node.next.next.next = new ListNode(3);
        l148.sortList(node);
    }
}
