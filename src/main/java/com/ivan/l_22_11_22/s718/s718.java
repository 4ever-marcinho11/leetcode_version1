package com.ivan.l_22_11_22.s718;

public class s718 {
    /**
     * @param nums1 整数数组
     * @param nums2 整数数组
     * @return 两个数组中 公共的 、长度最长的子数组的长度
     */
    public int findLength(int[] nums1, int[] nums2) {
        // dp[i][j]表示以nums1[i-1]、nums[j-1]为结尾的两个数组的最长重复子数组长度
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        int result = 0;
        //
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                if (dp[i][j] > result) {
                    result = dp[i][j];
                }
            }

        }

        return result;
    }
}
