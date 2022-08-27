package com.ivan.l_22_08_27.s112;

/**
 * @author Maximilian_Li
 */
public class s112 {
    /**
     * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
     * 如果存在，返回 true ；否则，返回 false 。
     *
     * @param root      根节点
     * @param targetSum 目标和
     * @return boolean
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // 首先更新targetSum
        targetSum -= root.val;

        // 叶子节点的情况下，递归的终止条件，叶子节点在他的父节点的过程中就被处理过
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        if (root.left != null) {
            boolean b = hasPathSum(root.left, targetSum);
            if (b) {
                return true;
            }
        }

        if (root.right != null) {
            boolean b = hasPathSum(root.right, targetSum);
            return b;
        }

        return false;
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
