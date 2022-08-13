package com.ivan.l_22_08_13.s454;

import java.util.HashMap;

/**
 * @author Maximilian_Li
 */
public class s454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;

        // 先求两个数组的两两数字和，并将结果和出现次数放入map中
        for (Integer i : nums1) {
            for (Integer j : nums2) {
                int temp = i + j;
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }

        // 从另两个数组中看是否有和为零的组合
        for (Integer i : nums3) {
            for (Integer j : nums4) {
                int temp = i + j;
                if (map.get(-temp) != null) {
                    result += map.get(-temp);
                }
            }
        }

        return result;
    }
}
