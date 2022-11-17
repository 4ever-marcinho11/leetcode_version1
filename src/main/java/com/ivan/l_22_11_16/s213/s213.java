package com.ivan.l_22_11_16.s213;

public class s213 {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
     * <p>
     * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * <p>
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     *
     * @param nums 代表每个房屋存放金额的非负整数数组
     * @return 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int part1 = robLinear(nums, 0, nums.length - 2);
        int part2 = robLinear(nums, 1, nums.length - 1);

        return Integer.max(part1, part2);
    }

    /**
     * 打家劫舍
     *
     * @param nums  数组
     * @param start 起始索引(included)
     * @param end   中止索引(included)
     * @return 线性数组中最大收益
     */
    public int robLinear(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Integer.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Integer.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[end];
    }
}
