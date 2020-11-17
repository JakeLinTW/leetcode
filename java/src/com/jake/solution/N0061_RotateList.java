package com.jake.solution;

import java.util.HashMap;
import java.util.Map;

public class N0061_RotateList {

    // made cycle and cut last link
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        // check list length
        int length = 1;
        ListNode last = head;
        while (last.next != null) {
            length++;
            last = last.next;
        }

        // rotate
        last.next = head;
        int cut = length - (k % length);
        for (int i = 0; i < cut; i++) {
            last = last.next;
        }
        head = last.next;
        last.next = null;
        return head;
    }

    // map index
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        Map<Integer, ListNode> indexMap = new HashMap<Integer, ListNode>();
        ListNode node = head;
        int length = 0;
        for (int i = 0; node != null; i++) {
            length++;
            indexMap.put(i, node);
            node = node.next;
        }

        ListNode tail = indexMap.get(length - 1);
        tail.next = head;

        ListNode newTail = indexMap.get(length - (k % length) - 1);
        head = newTail.next;
        newTail.next = null;

        return head;
    }

    // two pointer
    public ListNode rotateRight3(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = new ListNode(0, head);
        ListNode fast = pre;
        ListNode slow = pre;
        int length = 0;
        while (fast.next != null) {
            fast = fast.next;
            length++;
        }

        for (int i = 0; i < length - (k % length); i++) {
            slow = slow.next;
        }

        fast.next = pre.next;
        pre.next = slow.next;
        slow.next = null;
        return pre.next;
    }

    @SuppressWarnings("unused")
    private static class ListNode {
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
}
