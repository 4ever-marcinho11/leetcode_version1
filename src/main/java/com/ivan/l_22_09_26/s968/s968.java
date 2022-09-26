package com.ivan.l_22_09_26.s968;

/**
 * @author Maximilian_Li
 */
public class s968 {
    private int result;

    /**
     * 给定一个二叉树，我们在树的节点上安装摄像头。
     * <p>
     * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
     *
     * @param root 二叉树
     * @return 监控树的所有节点所需的最小摄像头数量。
     */
    public int minCameraCover(TreeNode root) {
        if (post(root) == 0) {
            result++;
        }

        return result;
    }

    /**
     * 返回当前节点应该的覆盖情况
     * <p>
     * 0：该节点无覆盖
     * <p>
     * 1：本节点有摄像头
     * <p>
     * 2：本节点有覆盖
     *
     * @param n 当前节点
     * @return 覆盖情况
     */
    private int post(TreeNode n) {
        if (n == null) {
            return 2;
        }

        // 当前节点子节点的覆盖情况
        int left = post(n.left);
        int right = post(n.right);

        // 左右子节点都被覆盖，本节点不必覆盖
        if (left == 2 && right == 2) {
            return 0;
        }

        // 左右子节点存在没有被覆盖的情况，这个节点需要有摄像头
        if (left == 0 || right == 0) {
            result++;
            return 1;
        }

        // 左右子节点有摄像头，这个节点处于被覆盖的状态
        if (left == 1 || right == 1) {
            return 2;
        }

        return -1;
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
