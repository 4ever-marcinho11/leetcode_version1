package com.ivan.l_22_10_07.s416;

/**
 * @author Maximilian_Li
 */
public class s416 {
    /**
     * @param nums 只包含正整数 的 非空 数组
     * @return 是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     */
    public boolean canPartition(int[] nums) {
        // 背包的体积为sum / 2
        // 背包要放入的商品（集合里的元素）重量为 元素的数值，价值也为元素的数值
        // 背包如果正好装满，说明找到了总和为 sum / 2 的子集。
        // 背包中每一个元素是不可重复放入

        int sumWeight = 0;
        for (int w : nums) {
            sumWeight += w;
        }

        if (sumWeight % 2 == 1) {
            return false;
        }

        int maxWeight = sumWeight / 2;
        int numOfGoods = nums.length;
        // i: 可以放到第i个元素, j: 限重为j
        int[][] dp = new int[numOfGoods][maxWeight + 1];

        // 初始化dp数组
        for (int i = nums[0]; i <= maxWeight; i++) {
            dp[0][i] = nums[0];
        }

        for (int iTh = 1; iTh < numOfGoods; iTh++) {
            for (int currMax = 1; currMax <= maxWeight; currMax++) {
                int weightOfI = nums[iTh - 1];
                int valueOfI = nums[iTh - 1];
                if (currMax < weightOfI) {
                    // 重量不够放
                    dp[iTh][currMax] = dp[iTh - 1][currMax];
                } else {
                    // 放
                    int yes = dp[iTh - 1][currMax - weightOfI] + valueOfI;
                    // 不放
                    int no = dp[iTh - 1][currMax];
                    dp[iTh][currMax] = Integer.max(yes, no);
                }
            }
        }

        return dp[numOfGoods - 1][maxWeight] == maxWeight;
    }
}
