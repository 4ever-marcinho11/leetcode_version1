package com.ivan.l_22_09_29.knapsack;

/**
 * @author Maximilian_Li
 */
public class Knapsack01 {
    /**
     * 有 n件物品和一个最多能背重量为 w 的背包。
     * <p>
     * 第i件物品的重量是weight[i]，得到的价值是value[i] 。
     * <p>
     * 每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
     */
    public void knapsack() {
        int[] weights = new int[]{1, 3, 4};
        int[] values = new int[]{15, 20, 30};
        int bagSize = 4;
        int numOfGoods = weights.length;

        // dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少
        int[][] dp = new int[numOfGoods + 1][bagSize + 1];

        // 背包容量为0时，价值一定为0
        for (int i = 0; i <= numOfGoods; i++) {
            dp[i][0] = 0;
        }

        for (int iTh = 1; iTh <= numOfGoods; iTh++) {
            for (int constrain = 1; constrain <= bagSize; constrain++) {
                // 减一是为了获得索引
                if (constrain < weights[iTh - 1]) {
                    // 要放的物品超重
                    dp[iTh][constrain] = dp[iTh - 1][constrain];
                } else {
                    // 放或不放
                    // 放了
                    int yes = dp[iTh - 1][constrain - weights[iTh - 1]] + values[iTh - 1];
                    // 不放
                    int no = dp[iTh - 1][constrain];
                    dp[iTh][constrain] = Integer.max(yes, no);
                }
            }
        }

        for (int i = 0; i <= numOfGoods; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }
}
