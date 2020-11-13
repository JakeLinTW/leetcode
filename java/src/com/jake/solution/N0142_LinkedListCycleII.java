package com.jake.solution;

import java.util.HashSet;
import java.util.Set;

public class N0142_LinkedListCycleII {

    // using hash set collect node
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (!set.add(head))
                return head;
            head = head.next;
        }
        return null;
    }

    // two pointer and hash set
    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode repeat = null;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                repeat = slow;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if (repeat != null) {
            Set<ListNode> set = new HashSet<ListNode>();
            while (set.add(repeat)) {
                repeat = repeat.next;
            }
            repeat = head;
            while (!set.contains(repeat)) {
                repeat = repeat.next;
            }
            return repeat;
        }
        return null;
    }

    // two pointer and calculate distance
    public ListNode detectCycle3(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next;
            if (slow == fast) {
                break;
            }
        }

        slow = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
