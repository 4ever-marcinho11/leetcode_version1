package com.ivan.l_22_07_18.s110;

public class s110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int lDepth = depth(root.left);
        int rDepth = depth(root.right);

        // 以root为根的树平衡
        // 以root.left为根的树平衡
        // 以root.right为根的树平衡
        return Math.abs(lDepth - rDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }


    public int depth(TreeNode n) {
        if (n == null) {
            return 0;
        }

        // 左子树深度
        int lDepth = depth(n.left);

        // 右子树深度
        int rDepth = depth(n.right);

        // 自己的深度也要算上
        return Math.max(lDepth, rDepth) + 1;
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
