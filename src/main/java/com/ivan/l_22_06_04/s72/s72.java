package com.ivan.l_22_06_04.s72;

public class s72 {
    public int minDistance(String word1, String word2) {
        // dp
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // base case
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            dp[0][i] = i;
        }

        // cases and choices
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 这两个字符相等，什么都不做
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 删除操作与插入操作所需操作数的最小值
                    int minDelIns = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                    // 上面的最小值与替换操作所需操作数的最小值
                    int minDelInsRep = Math.min(minDelIns, dp[i - 1][j - 1] + 1);
                    dp[i][j] = minDelInsRep;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
