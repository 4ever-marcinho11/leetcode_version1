package com.ivan.l_22_08_13.s15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s15 {
    /**
     * 在nums数组中找到abc三个数，使得和为零
     *
     * @param nums 数组
     * @return 三数之和为零的子数组的集合
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // 首先给数组排序
        Arrays.sort(nums);

        // 使用双指针法
        for (int i = 0; i < nums.length; i++) {
            // 第一个元素就大于零肯定不会出现和为零的组合
            if (nums[i] > 0) {
                return res;
            }

            // 对三元组的第一个元素去重，由于前面的元素已经经过遍历，所以要跟前面的比
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 使用双指针法找到三元组的后面两个数
            int left = i + 1, right = nums.length - 1;
            while (right > left) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    // 三数之和为零：加入结果集
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 对后面两个数去重
                    while (right > left && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    while (right > left && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    // 只有在找到答案时才同时收缩指针
                    right--;
                    left++;
                }
            }
        }

        return res;
    }
}
