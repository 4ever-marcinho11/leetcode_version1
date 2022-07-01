package com.ivan.l_22_06_30.s1482;

import java.util.Arrays;

public class s1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }

        // left、right指的是开花所需天数
        int left = Arrays.stream(bloomDay).min().getAsInt();
        int right = Arrays.stream(bloomDay).max().getAsInt();

        while (left <= right) {
            // mid指的是以mid天作为界限
            int mid = left + (right - left) / 2;
            if (canFinish(mid, bloomDay, k, m)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 在days天内，根据bloomDay，能否完成每束k朵花的m束花
     */
    public boolean canFinish(int limit, int[] bloomDay, int k, int m) {
        // 花束数目
        int bundle = 0;
        // 连续的花朵数目
        int consequenceFlower = 0;

        for (int day : bloomDay) {
            if (day <= limit) {
                // 能正常开花
                consequenceFlower++;
                if (consequenceFlower == k) {
                    // 可以作为一束花
                    bundle++;
                    consequenceFlower = 0;
                }
            } else {
                // 不能正常开花
                consequenceFlower = 0;
            }
            if (bundle >= m) {
                break;
            }
        }

        return bundle >= m;
    }
}
