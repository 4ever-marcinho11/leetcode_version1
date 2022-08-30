package com.ivan.l_22_08_30.s98;

import java.util.ArrayList;

public class s98 {
    public boolean isValidBST(TreeNode root) {
        // 得到中序遍历数组
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        int[] array = list.stream().mapToInt((one) -> one).toArray();

        // 判断是否严格递增
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= array[i + 1]) {
                return false;
            }
        }

        return true;
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
