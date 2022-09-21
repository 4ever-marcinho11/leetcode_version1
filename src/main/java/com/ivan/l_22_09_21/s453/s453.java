package com.ivan.l_22_09_21.s453;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Maximilian_Li
 */
public class s453 {
    /**
     * 给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。返回 需要移除区间的最小数量，使剩余区间互不重叠。
     *
     * @param intervals 区间的集合
     * @return 使剩余区间互不重叠时需要移除区间的最小数量
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // 选择从左至右遍历，那就按照右边界递增的顺序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        int notOverlap = 1;
        int rightBoundary = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= rightBoundary) {
                // 上一个区间的右边界小于当前区间的左边界
                notOverlap++;
                rightBoundary = intervals[i][1];
            } else {
                rightBoundary = Integer.min(rightBoundary, intervals[i][1]);
            }
        }

        return intervals.length - notOverlap;
    }
}
