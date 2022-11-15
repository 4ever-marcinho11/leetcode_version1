package com.ivan.l_22_11_15.s139;

import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s139 {
    /**
     * 请你判断是否可以利用字典中出现的单词拼接出s，不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     *
     * @param s        一个字符串
     * @param wordDict 一个字符串列表，作为字典
     * @return 是否可以利用字典中出现的单词拼接出s
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int bagsize = s.length();

        // dp[i]表示当字符串长度为i的时候，能不能由dict中的单词组成
        boolean[] dp = new boolean[bagsize + 1];
        dp[0] = true;

        for (int j = 1; j <= bagsize; j++) {
            for (int i = 0; i < j; i++) {
                if (dp[i] && wordDict.contains(s.substring(i, j))) {
                    dp[j] = true;
                    break;
                }
            }
        }

        return dp[bagsize];
    }
}
