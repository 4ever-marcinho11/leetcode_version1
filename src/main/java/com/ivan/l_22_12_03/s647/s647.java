package com.ivan.l_22_12_03.s647;

public class s647 {
    /**
     * 回文字符串 是正着读和倒过来读一样的字符串。
     * <p>
     * 子字符串 是字符串中的由连续字符组成的一个序列。
     * <p>
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     *
     * @param s 字符串
     * @return 字符串中回文子串的数目
     */
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];

        // 注意遍历顺序
        int nums = 0;
        for (int i = s.length(); i > 0; i--) {
            for (int j = i; j <= s.length(); j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        nums++;
                    } else {
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            nums++;
                        }
                    }
                }
            }
        }

        return nums;
    }
}
