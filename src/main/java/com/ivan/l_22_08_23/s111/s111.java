package com.ivan.l_22_08_23.s111;

/**
 * @author Maximilian_Li
 */
public class s111 {
    public int minDepth(TreeNode root) {
        return getMin(root);
    }

    public int getMin(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getMin(root.left);
        int right = getMin(root.right);

        if (root.left == null && root.right != null) {
            return right + 1;
        }

        if (root.left != null && root.right == null) {
            return left + 1;
        }

        return Integer.min(left, right) + 1;
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