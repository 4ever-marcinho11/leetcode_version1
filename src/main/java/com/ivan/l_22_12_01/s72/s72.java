package com.ivan.l_22_12_01.s72;

public class s72 {
    /**
     * 你可以对一个单词进行如下三种操作：
     * <p>
     * 插入一个字符
     * <p>
     * 删除一个字符
     * <p>
     * 替换一个字符
     *
     * @param word1 单词1
     * @param word2 单词2
     * @return 将word1转换成word2 所使用的最少操作数
     */
    public int minDistance(String word1, String word2) {
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
                    int two = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Integer.min(one, two);
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
