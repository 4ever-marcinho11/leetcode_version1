package com.ivan.l_22_06_05.s516;

public class s516 {
    public int longestPalindromeSubseq(String s) {
        // dp
        int[][] dp = new int[s.length()][s.length()];

        // base case：对角线为1；规定i<j，因此i>j的情况下为0
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        // cases and choices：倒着遍历
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
