package com.ivan.l_22_08_09.s209;

/**
 * @author Maximilian_Li
 */
public class s209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0, res = Integer.MAX_VALUE;

        while (right < nums.length) {
            int r = nums[right++];
            sum += r;

            while (target <= sum) {
                // 当前长度
                int subLen = right - left;
                // 更新最小长度
                res = Math.min(res, subLen);
                int l = nums[left++];
                sum -= l;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
