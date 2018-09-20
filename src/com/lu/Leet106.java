package com.lu;

import com.lu.util.TreeNode;

public class Leet106 {
    private TreeNode buildTree(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2){
        if(s1 > e1)
            return null;
        if(s1 == e1 && s2 == e2){
            TreeNode node = new TreeNode(inorder[s1]);
            return node;
        }

        TreeNode node = new TreeNode(postorder[e2]);

        int count = 0;
        while(inorder[s1+count] != postorder[e2])
            count++;
        node.left = buildTree(inorder, s1, s1+count-1, postorder, s2, s2+count-1);
        node.right = buildTree(inorder, s1+count+1, e1, postorder, s2+count, e2-1);
        return node;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public static void main(String[] args){
        Leet106 l106 = new Leet106();
        TreeNode node = l106.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }
}
