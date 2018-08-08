package com.lu;

import com.lu.util.TreeNode;

public class Leet114 {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.left);
        flatten(root.right);
        if (root.left == null)
            return;

        TreeNode left = root.left;
        root.left = null;
        TreeNode leftMost = left;
        while (leftMost.right != null)
            leftMost = leftMost.right;
        leftMost.right = root.right;
        root.right = left;
    }
}
