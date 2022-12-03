package com.ivan.l_22_12_03.s516;

public class s516 {
    /**
     * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
     *
     * @param s 字符串
     * @return 最长的回文子序列的长度
     */
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    int left = dp[i][j - 1];
                    int all = dp[i][j];
                    int right = dp[i + 1][j];
                    dp[i][j] = Integer.max(left, Integer.max(all, right));
                }
            }
        }

        return dp[0][len - 1];
    }
}
