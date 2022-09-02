package com.ivan.l_22_09_02.s538;

/**
 * @author Maximilian_Li
 */
public class s538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {

        // 使用自底向上，从右至左的方式求解
        accumulate(root);
        return root;
    }

    public void accumulate(TreeNode root) {
        if (root == null) {
            return;
        }

        accumulate(root.right);
        sum += root.val;
        root.val = sum;
        accumulate(root.left);
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
