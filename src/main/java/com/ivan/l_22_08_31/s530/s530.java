package com.ivan.l_22_08_31.s530;

import java.util.ArrayList;

public class s530 {
    public int getMinimumDifference(TreeNode root) {
        // 由于是二叉搜索树，首先将中序遍历数组获得
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        int[] ints = list.stream().mapToInt((one) -> one).toArray();

        int minAbs = Integer.MAX_VALUE;
        int size = ints.length;
        for (int i = 0; i < size - 1; i++) {
            minAbs = Math.min(minAbs, Math.abs(ints[i] - ints[i + 1]));
        }

        return minAbs;
    }

    public void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
