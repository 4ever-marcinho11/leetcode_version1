package com.ivan.l_22_05_29.s1;

import java.util.HashMap;

/**
 * @author Maximilian_Li
 */
public class s1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // 装载
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // 查找
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            Integer anoIdx = map.get(another);
            if (anoIdx != null && anoIdx != i) {
                return new int[]{i, anoIdx};
            }
        }
        return null;
    }
}
