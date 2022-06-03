package com.ivan.l_22_05_29.s354;

import java.util.Arrays;

/**
 * @author Maximilian_Li
 */
public class s354 {
    public int maxEnvelopes(int[][] envelopes) {
        // 按照宽度升序排序，当宽度相等时，按照高度降序排序
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // 根据高度依次寻找最长递增子序列
        int[] h = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            h[i] = envelopes[i][1];
        }

        return maxLength(h);
    }

    public int maxLength(int[] arr) {
        int[] top = new int[arr.length];
        int piles = 0;

        for (int tar : arr) {
            int left = 0, right = piles, mid = 0;

            while (left < right) {
                mid = left + (right - left) / 2;
                if (tar == top[mid]) {
                    right = mid;
                } else if (tar > top[mid]) {
                    left = mid + 1;
                } else if (tar < top[mid]) {
                    right = mid;
                }
            }

            if (left == piles) {
                piles++;
            }
            top[left] = tar;
        }
        return piles;
    }
}
