package com.ivan.l_22_08_01.s35;

public class s35 {
    public int searchInsert(int[] nums, int target) {
        int size = nums.length;
        int left = 0, right = size - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }

        System.out.println("left = " + left);
        System.out.println("right = " + right);

        return left;
    }
}
