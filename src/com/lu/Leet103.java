package com.lu;

import com.lu.util.TreeNode;

import java.util.*;

public class Leet103 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean backOrder = true;

        while (queue.size() > 0) {
            backOrder = !backOrder;
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (backOrder) {
                    stack.add(node);
                } else {
                    level.add(node.val);
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            while (stack.size() > 0)
                level.add(stack.pop().val);
            result.add(level);
        }
        return result;
    }
}
