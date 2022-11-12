package com.ivan.l_22_11_08.knapsack01;

/**
 * @author Maximilian_Li
 */
public class Knapsack {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagsize = 4;
        use2d(weight, value, bagsize);
        use1d(weight, value, bagsize);
    }

    /**
     * 使用二维数组作为dp数组
     *
     * @param weight  重量
     * @param value   价值
     * @param bagsize 限重
     */
    public static void use2d(int[] weight, int[] value, int bagsize) {
        // dp[i][j]表示容量为j的背包中放0-i下标对应的任意一个物品
        int[][] dp = new int[weight.length][bagsize + 1];

        // 初始化
        for (int i = 0; i < weight.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = weight[0]; i <= bagsize; i++) {
            dp[0][i] = value[0];
        }

        // 按行遍历: 先遍历物品再遍历容量
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagsize; j++) {
                if (j < weight[i]) {
                    // 第i号物品放不进去容量为j的背包
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Integer.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }

        // 打印矩阵
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= bagsize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.print("\n");
        }

        System.out.println(dp[weight.length - 1][bagsize]);
    }

    /**
     * 使用一维数组作为dp数组
     *
     * @param weight  重量
     * @param value   价值
     * @param bagsize 限重
     */
    public static void use1d(int[] weight, int[] value, int bagsize) {
        /*
        原递推表达式: dp[i][j] = max( dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i] )
        现递推表达式: dp[j] = max( dp[j], dp[j - weight[i]] + value[i] )
        */

        // 声明，默认初始化为0
        int[] dp = new int[bagsize + 1];

        // 初始化
        for (int i = weight[0]; i <= bagsize; i++) {
            dp[i] = value[0];
        }

        // 遍历物品
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagsize; j >= weight[i]; j--) {
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
