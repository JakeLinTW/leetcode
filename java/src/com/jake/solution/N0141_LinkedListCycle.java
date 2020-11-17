package com.jake.solution;

import java.util.HashSet;
import java.util.Set;

public class N0141_LinkedListCycle {

    // using hash set collect node
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (!set.add(head))
                return true;
            head = head.next;
        }
        return false;
    }

    // replace next node ( this will modify the linked list )
    public boolean hasCycle2(ListNode head) {
        ListNode checked = new ListNode(0);
        while (head != null) {
            if (checked.equals(head.next))
                return true;
            ListNode next = head.next;
            head.next = checked;
            head = next;
        }
        return false;
    }

    // two pointer
    public boolean hasCycle3(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    @SuppressWarnings("unused")
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
