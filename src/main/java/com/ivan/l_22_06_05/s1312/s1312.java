package com.ivan.l_22_06_05.s1312;

import java.util.Arrays;

public class s1312 {
    public int minInsertions(String s) {
        // dp
        int[][] dp = new int[s.length()][s.length()];

        // base case
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], 0);
        }

        // cases and choices
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
