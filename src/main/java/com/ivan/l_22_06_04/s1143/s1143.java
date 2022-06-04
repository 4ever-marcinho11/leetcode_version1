package com.ivan.l_22_06_04.s1143;

public class s1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        // dp：dp[i][j]表示在text1[i]、text2[j]位置下的最长公共子序列
        // 行为text1，列为text2
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // base case：第一行第一列都为0
        for (int i = 0; i < text1.length() + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < text2.length() + 1; i++) {
            dp[0][i] = 0;
        }

        // cases and choices
        // i与j是dp的下标，对应到text1与text2时要减1
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 两个字符相同：左上角的值加1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 两个字符不同：取左侧与上方的更大值
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
