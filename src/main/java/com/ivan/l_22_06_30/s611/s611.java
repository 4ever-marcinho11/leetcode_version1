package com.ivan.l_22_06_30.s611;

import java.util.Arrays;

public class s611 {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 右边界，k的初始化无所谓
                int left = j + 1, right = n - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[i] + nums[j] > nums[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;

                    }
                }
                res += right - j;
            }
        }
        return res;
    }


}
