package com.ivan.l_22_08_07.s977;

/**
 * @author Maximilian_Li
 */
public class s977 {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int idx = nums.length - 1;

        for (int i = 0, j = nums.length - 1; i <= j; ) {
            int i2 = nums[i] * nums[i];
            int j2 = nums[j] * nums[j];

            if (i2 < j2) {
                result[idx] = j2;
                j--;
            } else {
                result[idx] = i2;
                i++;
            }
            idx--;
        }

        return result;
    }
}
