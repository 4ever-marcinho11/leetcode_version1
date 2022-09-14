package com.ivan.l_22_09_14.s45;

/**
 * @author Maximilian_Li
 */
public class s45 {
    /**
     * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * <p>
     * 假设你总是可以到达数组的最后一个位置。
     *
     * @param nums 非负整数数组nums
     * @return 跳跃次数
     */
    public int jump(int[] nums) {
        // 跳跃步数
        int res = 0;
        // 当前最远位置
        int crrMax = 0;
        // 下一步最远覆盖范围
        int nextMax = 0;

        for (int i = 0; i < nums.length; i++) {
            // 更新下一步最远覆盖范围
            nextMax = Integer.max(nextMax, nums[i] + i);

            if (i == crrMax) {
                //
                if (crrMax != nums.length - 1) {
                    // 未到终点
                    res++;
                    crrMax = nextMax;
                    if (nextMax >= nums.length - 1) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        return res;
    }
}
