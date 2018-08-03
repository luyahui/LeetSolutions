package com.lu;

//Definition for singly-linked list.

import com.lu.util.ListNode;

class Leet21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null, prev = null;
        ListNode p1 = l1, p2 = l2;

        while (p1 != null && p2 != null) {
            ListNode temp;
            if (p1.val <= p2.val) {
                temp = p1;
                p1 = p1.next;
            } else {
                temp = p2;
                p2 = p2.next;
            }

            if (prev == null) {
                result = temp;
                result.next = null;
                prev = result;
            } else {
                prev.next = temp;
                prev = prev.next;
                prev.next = null;
            }
        }

        if (p2 != null) {
            p1 = p2;
        }

        if (prev == null)
            result = p1;
        else
            prev.next = p1;
        return result;
    }

}