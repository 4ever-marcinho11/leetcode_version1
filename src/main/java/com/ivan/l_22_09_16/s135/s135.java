package com.ivan.l_22_09_16.s135;

import java.util.Arrays;

/**
 * @author Maximilian_Li
 */
public class s135 {
    /**
     * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
     * <p>
     * 你需要按照以下要求，给这些孩子分发糖果：
     * <p>
     * 每个孩子至少分配到 1 个糖果。
     * 相邻两个孩子评分更高的孩子会获得更多的糖果。
     * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
     *
     * @param ratings 孩子的评分
     * @return 最少糖果数目
     */
    public int candy(int[] ratings) {
        int[] sum = new int[ratings.length];
        Arrays.fill(sum, 1);

        // 从左向右，给相邻两个右侧更高的加分
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                // 首次遍历，直接加即可
                sum[i + 1] = sum[i] + 1;
            }
        }

        // 从左向右，给相邻两个左侧更高的加分
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                // 非首次遍历，取右侧加1值与当前值最大值
                sum[i - 1] = Integer.max(ratings[i - 1], sum[i] + 1);
            }
        }

        return Arrays.stream(sum).sum();
    }
}
