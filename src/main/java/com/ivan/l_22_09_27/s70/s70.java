package com.ivan.l_22_09_27.s70;

public class s70 {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * @param n 需要 n 阶
     * @return 多少种不同的方法
     */
    public int climbStairs(int n) {
        // 爬三个楼梯：三种方法
        // 爬一个楼梯：一种方法
        // 爬两个楼梯：两种方法
        // 实际上就是斐波那契问题
        int[] dp = new int[]{0, 1, 2};

        if (n <= 2) {
            return dp[n];
        }

        for (int i = 3; i <= n; i++) {
            int sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }

        return dp[2];
    }
}
