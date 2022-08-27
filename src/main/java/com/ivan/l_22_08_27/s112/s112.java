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
        return traversal(root, targetSum - root.val);
    }

    public boolean traversal(TreeNode node, int count) {
        // 叶子节点的情况下，递归的终止条件
        if (node.left == null && node.right == null && count != 0) {
            return false;
        } else if (node.left == null && node.right == null && count == 0) {
            return true;
        }

        if (node.left != null) {
            // 左子节点存在
            count -= node.left.val;
            boolean b = traversal(node.left, count);
            if (b) {
                // 走这条路找到了一条合理路径
                return true;
            } else {
                // 回溯
                count += node.left.val;
            }
        }

        if (node.right != null) {
            // 右子节点存在
            count -= node.right.val;
            boolean b = traversal(node.right, count);
            if (b) {
                // 走这条路找到了一条合理路径
                return true;
            } else {
                // 回溯
                count += node.right.val;
            }
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
