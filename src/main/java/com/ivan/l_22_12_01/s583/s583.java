package com.ivan.l_22_12_01.s583;

public class s583 {
    /**
     * 每步 可以删除任意一个字符串中的一个字符
     *
     * @param word1 单词1
     * @param word2 单词2
     * @return 使得 word1 和  word2 相同所需的最小步数
     */
    public int minDeleteTimes(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int one = Integer.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                    int two = dp[i - 1][j - 1] + 2;
                    dp[i][j] = Integer.min(one, two);
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public int maxCommonSubsequences(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Integer.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }
}
