package com.ivan.l_22_11_15.summary_one;

/**
 * @author Maximilian_Li
 */
public class Summary {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagsize = 4;

        int h = k01_2d(weight, value, bagsize);
        int i = k01_1d(weight, value, bagsize);
        int j = kComplete_1d(weight, value, bagsize);

        System.out.println(h);
        System.out.println(i);
        System.out.println(j);
    }

    public static int k01_2d(int[] weight, int[] value, int bagsize) {
        // declare
        int[][] dp = new int[weight.length][bagsize + 1];

        // init
        for (int i = 0; i < weight.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = weight[0]; j <= bagsize; j++) {
            dp[0][j] = value[0];
        }

        // loop, outer: item, inner: weight limit
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagsize; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
            }
        }

        return dp[weight.length - 1][bagsize];
    }

    public static int k01_1d(int[] weight, int[] value, int bagsize) {
        int[] dp = new int[bagsize + 1];

        for (int j = weight[0]; j <= bagsize; j++) {
            dp[j] = value[0];
        }

        for (int i = 0; i < weight.length; i++) {
            for (int j = bagsize; j >= weight[i]; j--) {
                dp[j] = Integer.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        return dp[bagsize];
    }

    public static int kComplete_1d(int[] weight, int[] value, int bagsize) {
        int[] dp = new int[bagsize + 1];

        for (int j = weight[0]; j <= bagsize; j++) {
            dp[j] = value[0];
        }

        /*
        如果求组合数就是外层for循环遍历物品，内层for遍历背包。
        如果求排列数就是外层for遍历背包，内层for循环遍历物品。
        */
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= bagsize; j++) {
                dp[j] = Integer.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        return dp[bagsize];
    }
}
