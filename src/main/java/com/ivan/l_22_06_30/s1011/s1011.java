package com.ivan.l_22_06_30.s1011;

import java.util.Arrays;

public class s1011 {
    public int shipWithinDays(int[] weights, int days) {
        int minAbility = Arrays.stream(weights).min().getAsInt();
        int maxAbility = Arrays.stream(weights).sum();

        // 对于左边界，由于我们不能拆分一个包裹，因此船的运载能力不能小于所有包裹中最重的那个的重量，即左边界为数组weights中元素的最大值。
        // 对于右边界，船的运载能力也不会大于所有包裹的重量之和，即右边界为数组{weights中元素的和。
        int left = minAbility, right = maxAbility;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinish(days, mid, weights)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * 在days天内以load的工作量完成mission的任务
     */
    public boolean canFinish(int days, int load, int[] weights) {
        int idx = 0;
        for (int i = 0; i < days; i++) {
            int spaceRemained = load;
            while ((spaceRemained -= weights[idx]) >= 0) {
                idx++;
                if (idx == weights.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
