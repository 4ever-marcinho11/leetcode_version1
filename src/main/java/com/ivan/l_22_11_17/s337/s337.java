package com.ivan.l_22_11_17.s337;

public class s337 {
    /**
     * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为root。
     * <p>
     * 除了root之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
     * <p>
     * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
     *
     * @param root 二叉树的root
     * @return 在不触动警报的情况下，小偷能够盗取的最高金额
     */
    public int rob(TreeNode root) {
        int[] decision = post(root);
        return Integer.max(decision[0], decision[1]);
    }

    /**
     * 需要用递归函数返回值进行后续计算的遍历方式一定是后序遍历
     *
     * @param c 当前节点
     * @return dp[](2): {考虑，不考虑}
     */
    public int[] post(TreeNode c) {
        if (c == null) {
            return new int[]{0, 0};
        }

        int[] dpLeft = post(c.left);
        int[] dpRight = post(c.right);

        // 偷，子节点都不能偷
        int stole = c.val + dpLeft[0] + dpRight[0];
        // 不偷，子节点可以考虑偷
        int unstole = Integer.max(dpLeft[0], dpLeft[1]) + Integer.max(dpRight[0], dpRight[1]);

        return new int[]{unstole, stole};
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
