package com.lu;

import com.lu.util.TreeNode;

import java.util.Arrays;

public class Leet105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0)
            return null;
        int length = 0;
        while (inorder[length] != preorder[0])
            length++;
        TreeNode node = new TreeNode(preorder[0]);
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, length+1), Arrays.copyOfRange(inorder, 0, length));
        node.right = buildTree(Arrays.copyOfRange(preorder, length + 1, preorder.length), Arrays.copyOfRange(inorder, length + 1, inorder.length));
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        new Leet105().buildTree(preorder, inorder);
    }
}
