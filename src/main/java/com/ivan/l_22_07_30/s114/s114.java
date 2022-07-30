package com.ivan.l_22_07_30.s114;

import java.util.ArrayList;

public class s114 {
    private final ArrayList<Integer> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        preorder(root);

        TreeNode ptr = root;
        for (int i = 1; i < list.size(); i++) {
            ptr.left = null;
            ptr.right = new TreeNode(list.get(i), null, null);
            ptr = ptr.right;
        }
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
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

