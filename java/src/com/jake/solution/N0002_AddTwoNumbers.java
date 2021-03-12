package com.jake.solution;

public class N0002_AddTwoNumbers {

    // TODO optimize
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        addNumbers(l1, l2);
        return l1;
    }

    private void addNumbers(ListNode to, ListNode from) {
        int carry = 0;
        while (carry != 0 || from != null) {
            if (from != null) {
                to.val += from.val;
            }
            to.val += carry;
            carry = to.val / 10;
            to.val %= 10;

            if (from != null) {
                from = from.next;
            }
            if ((from != null || carry != 0) && to.next == null) {
                to.next = new ListNode();
            }
            to = to.next;
        }
    }

    @SuppressWarnings("unused")
    private class ListNode {
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
