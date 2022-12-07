package com.ivan.l_22_12_07.s84;

public class s84 {
    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * <p>
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     *
     * @param heights n 个非负整数，用来表示柱状图中各个柱子的高度
     * @return 能够勾勒出来的矩形的最大面积
     */
    public int largestRectangleArea(int[] heights) {
        // dpL[i]表示第i根左侧第一个比它矮的柱子的下标
        int[] dpL = new int[heights.length];
        // dpR[i]表示第i根右侧第一个比它矮的柱子的下标
        int[] dpR = new int[heights.length];

        dpL[0] = -1;
        dpR[heights.length - 1] = heights.length;

        for (int i = 1; i < heights.length; i++) {
            int idx = i - 1;
            while (idx >= 0 && heights[idx] >= heights[i]) {
                idx = dpL[idx];
            }
            dpL[i] = idx;
        }

        for (int i = heights.length - 2; i >= 0; i--) {
            int idx = i + 1;
            while (idx < heights.length && heights[idx] >= heights[i]) {
                idx = dpR[idx];
            }
            dpR[i] = idx;
        }

        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (dpR[i] - dpL[i] - 1);
            result = Integer.max(area, result);
        }

        return result;
    }
}
