package com.ivan.l_22_11_07.s96;

/**
 * @author Maximilian_Li
 */
public class s96 {
    public int numTrees(int n) {
        // -> dp[i]: i个节点构成的二叉搜索树的数目
        int[] dp = new int[n + 1];
        // -> 赋初值
        dp[0] = 1;

        // -> 递推函数与遍历方向
        // 节点数目i
        for (int i = 2; i <= n; i++) {
            // 头节点j
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
