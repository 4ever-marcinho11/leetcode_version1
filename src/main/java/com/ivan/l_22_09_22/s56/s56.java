package com.ivan.l_22_09_22.s56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class s56 {
    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     *
     * @param intervals 若干个区间的集合
     * @return 不重叠的区间数组
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }

        // 根据起始点将数组排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] s) {
                return Integer.compare(a[0], s[0]);
            }
        });

        int sBoundary = intervals[0][0];
        int eBoundary = intervals[0][1];
        List<int[]> list = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > eBoundary) {
                // 无重叠
                list.add(new int[]{sBoundary, eBoundary});

                //更新
                sBoundary = intervals[i][0];
                eBoundary = intervals[i][1];
            } else {
                // 有重叠
                eBoundary = Integer.max(eBoundary, intervals[i][1]);
            }
        }

        list.add(new int[]{sBoundary, eBoundary});
        return list.toArray(new int[list.size()][]);
    }
}
