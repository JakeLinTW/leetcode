package com.jake.solution;

public class N0019_RemoveNthNodeFromEndOfList {

    // get remove item's index first
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int removeIdx = count - n;

        if (removeIdx == 0) {
            return head.next;
        }

        temp = head;

        for (int i = 1; i < removeIdx; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }

    // TODO two pointer, one way pass
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        return head;
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
