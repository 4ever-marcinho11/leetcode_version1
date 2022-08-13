package com.ivan.l_22_08_13.s18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s18 {
    /**
     * 在nums中找到abcd四个数字，其和为target
     *
     * @param nums   数组
     * @param target 目标数字
     * @return 集合
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > target) {
                return res;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (right > left && nums[left + 1] == nums[left]) {
                            left++;
                        }
                        while (right > left && nums[right - 1] == nums[right]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }

        return res;
    }
}
