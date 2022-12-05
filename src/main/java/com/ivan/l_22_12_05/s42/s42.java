package com.ivan.l_22_12_05.s42;

public class s42 {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * @param height 非负整数数组
     * @return 下雨后能接多少雨水
     */
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }

        // 左侧最近更高，右侧最近更高
        int[] dpLeft = new int[height.length];
        int[] dpRight = new int[height.length];

        dpLeft[0] = height[0];
        dpRight[height.length - 1] = height[height.length - 1];

        // 自己？一侧更高？
        for (int i = 1; i < height.length; i++) {
            dpLeft[i] = Integer.max(height[i], dpLeft[i - 1]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            dpRight[i] = Integer.max(height[i], dpRight[i + 1]);
        }

        // 求和
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int vol = Integer.min(dpLeft[i], dpRight[i]) - height[i];
            if (vol > 0) {
                sum += vol;
            }
        }

        return sum;
    }
}
