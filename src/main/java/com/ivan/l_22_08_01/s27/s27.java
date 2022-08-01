package com.ivan.l_22_08_01.s27;

public class s27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        // [0, slow)
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                if (fast > slow) {
                    nums[slow] = nums[fast];
                }
                slow++;
            }
        }

        return slow;
    }
}
