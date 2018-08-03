package com.lu;

import com.lu.util.ListNode;

public class Leet23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null, prev = null;
        while (true) {
            ListNode temp = null;
            int position = -1;
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node == null)
                    continue;
                if (temp == null || node.val < temp.val) {
                    temp = node;
                    position = i;
                }

            }
            if (temp == null)
                break;
            lists[position] = temp.next;

            if (prev == null) {
                result = temp;
                prev = result;
                prev.next = null;
            } else {
                prev.next = temp;
                prev = prev.next;
                prev.next = null;
            }
        }

        return result;
    }
}
