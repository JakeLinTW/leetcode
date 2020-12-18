package com.jake.solution;

import java.util.HashMap;
import java.util.Map;

public class N0138_CopyListWithRandomPointer {

    // using hash map to mapping node and copy node
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<Node, Node>();

        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        node = head;
        while (node != null) {
            Node copyNode = map.get(node);
            copyNode.next = map.get(node.next);
            copyNode.random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
    
    // TODO interweave node and copy node to avoid using extra space

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
