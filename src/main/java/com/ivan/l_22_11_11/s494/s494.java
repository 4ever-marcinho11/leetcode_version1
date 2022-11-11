package com.ivan.l_22_11_11.s494;

import java.util.Arrays;

/**
 * @author Maximilian_Li
 */
public class s494 {
    /**
     * 向数组中的每个整数前添加'+'或 '-'，然后串联起所有整数，可以构造一个表达式
     * <p>
     * 例如，nums = [2, 1]，可以在 2 之前添加'+'，在 1之前添加'-'，然后串联起来得到表达式"+2-1"
     * 返回。
     *
     * @param nums   整数数组
     * @param target 整数
     * @return 可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();

        // judge
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        if (Math.abs(target) > sum) {
            return 0;
        }

        int bagsize = Math.abs((target + sum) / 2);

        // dp[i]: 填满i(包括i)这么大容积的包，有dp[i]种方法
        int[] dp = new int[bagsize + 1];
        dp[0] = 1;

        // loop
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagsize; j >= nums[i]; j--) {
                if (nums[i] > j) {
                    dp[j] = dp[j - 1];
                    continue;
                }
                // 在求装满背包有几种方法的情况下，递推公式一般为:
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[bagsize];
    }
}
