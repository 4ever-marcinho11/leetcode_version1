package com.ivan.l_22_05_31.s31;

public class s31 {
    public void nextPermutation(int[] nums) {
        // 目的：找到比当前数字更大的最小数字

        // 从后往前找第一个降序的数字，位置记为idx。
        int idx = nums.length - 2;
        while (idx >= 0 && nums[idx] >= nums[idx + 1]) {
            idx--;
        }

        // 如果这个位置在范围内
        if (idx >= 0) {
            // 找比这个数字及之后的数字组成的数大且最小的位置ptr
            int ptr = nums.length - 1;
            for (int i = ptr; i > idx; i--) {
                if (nums[i] > nums[idx]) {
                    ptr = i;
                    break;
                }
            }

            // 交换idx与ptr位置的数字
            int temp = nums[idx];
            nums[idx] = nums[ptr];
            nums[ptr] = temp;
        }

        // idx之后的数字应该保持最小——升序排列
        int left = idx + 1, right = nums.length - 1;
        while (left < right) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }
    }
}
