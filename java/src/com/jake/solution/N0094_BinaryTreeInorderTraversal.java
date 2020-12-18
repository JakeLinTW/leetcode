package com.jake.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N0094_BinaryTreeInorderTraversal {
    
    // using stack
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                stack.push(node);
                node = node.left;
            } else {
                ans.add(node.val);
                if (node.right != null) {
                    node = node.right;
                } else {
                    while (!stack.isEmpty()) {
                        node = stack.pop();
                        ans.add(node.val);
                        if (node.right != null) {
                            break;
                        }
                    }
                    node = node.right;
                }
            }
        }
        return ans;
    }
    
    // TODO optimize
    
    @SuppressWarnings("unused")
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
