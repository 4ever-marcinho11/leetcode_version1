package com.ivan.l_22_08_01.s26;

public class s26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int ptr = 0;
        int slow = 0, fast = 1;

        while (fast <= nums.length - 1) {
            if (nums[slow] != nums[fast]) {
                ptr++;
                nums[ptr] = nums[fast];
            }
            slow++;
            fast++;
        }

        return ptr + 1;
    }
}
