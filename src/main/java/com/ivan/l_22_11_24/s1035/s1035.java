package com.ivan.l_22_11_24.s1035;

public class s1035 {
    /**
     * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
     * <p>
     * 现在，可以绘制一些连接两个数字 nums1[i]和 nums2[j]的直线，这些直线需要同时满足满足：
     * <p>
     * nums1[i] == nums2[j]
     * <p>
     * 且绘制的直线不与任何其他连线（非水平线）相交。
     * <p>
     * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
     *
     * @param nums1 整数数组
     * @param nums2 整数数组
     * @return 可以绘制的最大连线数
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 直线不能相交，这就是说明在字符串A中 找到一个与字符串B相同的子序列，且这个子序列不能改变相对顺序，只要相对顺序不改变，连接相同数字的直线就不会相交。
        // 转为求两个数组的最长公共子序列

        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[nums1.length][nums2.length];

    }
}
