package com.ivan.l_22_08_04.s34;

public class s34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];

        // 查找左侧边界的二分查找
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        // 检查是否越界
        if (left >= nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        res[0] = left;

        // 查找右侧边界的二分查找
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] <= target) {
                left = mid + 1;
            }
        }
        // 检查是否越界
        if (right >= nums.length || nums[right] != target) {
            return new int[]{-1, -1};
        }
        res[1] = right;

        return res;
    }
}
