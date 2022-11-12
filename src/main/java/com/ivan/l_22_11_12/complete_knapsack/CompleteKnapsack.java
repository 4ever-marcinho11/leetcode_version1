package com.ivan.l_22_11_12.complete_knapsack;

/**
 * @author Maximilian_Li
 */
public class CompleteKnapsack {
    /**
     * 有N件物品和一个最多能背重量为W的背包。
     * <p>
     * 第i件物品的重量是weight[i]，得到的价值是value[i]。
     * <p>
     * 每件物品都有无限个（也就是可以放入背包多次），求解将哪些物品装入背包里物品价值总和最大。
     *
     * @param args 程序运行参数
     */
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagsize = 4;

        // declare
        int[] dp = new int[bagsize + 1];

        // init
        for (int i = weight[0]; i <= bagsize; i++) {
            dp[i] = value[0];
        }

        // loop
        for (int i = 0; i < weight.length; i++) {
            // 完全背包要从头遍历
            for (int j = weight[i]; j <= bagsize; j++) {
                dp[j] = Integer.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        // 打印矩阵
        for (int j = 0; j <= bagsize; j++) {
            System.out.print(dp[j] + "\t");
        }
        System.out.print("\n");

        System.out.println(dp[bagsize]);
    }
}
