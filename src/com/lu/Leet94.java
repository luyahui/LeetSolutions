package com.lu;

import com.lu.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;

        while(stack.size() > 0 || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }

        return result;
    }
}
