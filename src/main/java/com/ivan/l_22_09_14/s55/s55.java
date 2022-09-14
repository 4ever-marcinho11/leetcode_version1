package com.ivan.l_22_09_14.s55;

/**
 * @author Maximilian_Li
 */
public class s55 {
    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 判断你是否能够到达最后一个下标。
     *
     * @param nums 非负整数数组
     * @return 是否能到达最后一个下标
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        // 当前位置最大步数
        int maxCover = 0;
        for (int i = 0; i <= maxCover; i++) {
            // 更新最大步数
            maxCover = Integer.max(maxCover, i + nums[i]);
            if (maxCover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
