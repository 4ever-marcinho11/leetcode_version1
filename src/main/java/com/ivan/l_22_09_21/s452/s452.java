package com.ivan.l_22_09_21.s452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Maximilian_Li
 */
public class s452 {
    /**
     * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。
     * 墙面上的气球记录在整数数组points，其中points[i] = [xstart, xend]表示水平直径在xstart和xend之间的气球。
     * 你不知道气球的确切 y 坐标。
     * <p>
     * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。
     * 在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足 xstart≤ x ≤ xend，则该气球会被 引爆。
     * 可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
     * <p>
     * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数。
     *
     * @param points 墙面上的气球
     * @return 引爆所有气球所必须射出的 最小 弓箭数
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        // 根据起始点将数组进行排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // 防止差值过大而产生溢出
                return Integer.compare(a[0], b[0]);
            }
        });

        // 最少需要一只箭
        int numOfArrow = 1;
        // 前一个的右边界
        int rightBoundary = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // 当等于时也可以射穿
            if (points[i][0] > rightBoundary) {
                numOfArrow++;
                rightBoundary = points[i][1];
            } else {
                rightBoundary = Integer.min(rightBoundary, points[i][1]);
            }
        }

        return numOfArrow;
    }
}
