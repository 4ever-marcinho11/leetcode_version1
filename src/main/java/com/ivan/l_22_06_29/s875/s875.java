package com.ivan.l_22_06_29.s875;

import java.util.Arrays;

public class s875 {
    public int minEatingSpeed(int[] piles, int h) {
        // 有最多香蕉的堆的香蕉数目，同时也是最大速度
        int max = Arrays.stream(piles).max().getAsInt();

        // 由于是寻找最小速度，套用寻找左侧边界的二分查找
        int left = 1, right = max + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEat(h, mid, piles)) {
                // 能吃完：mid速度足够，还要继续找左侧边界
                right = mid;
            } else {
                // 不能吃完：mid速度不够
                left = mid + 1;
            }
        }

        // 返回左侧边界
        return left;
    }

    /**
     * 是否能在h小时内以mid的速度吃完这几堆香蕉
     */
    public boolean canEat(int h, int speed, int[] piles) {
        int timeUsed = 0;
        for (int pile : piles) {
            int part1 = pile / speed;
            int part2 = pile % speed;
            int sum = part1 + (part2 == 0 ? 0 : 1);
            timeUsed += sum;
        }

        return timeUsed <= h;
    }
}
