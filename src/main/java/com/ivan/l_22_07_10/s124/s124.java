package com.ivan.l_22_07_10.s124;

public class s124 {
    public int finalAns = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMax(root);
        return finalAns;
    }

    public int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = findMax(root.left);
        int right = findMax(root.right);

        int all = root.val + Math.max(0, left) + Math.max(0, right);
        int part = root.val + Math.max(0, Math.max(left, right));

        finalAns = Math.max(finalAns, Math.max(all, part));

        return part;
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
