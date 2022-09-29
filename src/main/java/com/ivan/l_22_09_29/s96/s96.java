package com.ivan.l_22_09_29.s96;

/**
 * @author Maximilian_Li
 */
public class s96 {
    /**
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     *
     * @param n 整数 n
     * @return 恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 的数目
     */
    public int numTrees(int n) {
        // dp[i]：节点1到i组成的二叉搜索树的数目
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            // j为头节点元素
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
