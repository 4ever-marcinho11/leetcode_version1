package com.ivan.l_22_09_22.s763;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s763 {
    /**
     * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
     *
     * @param s 由小写字母组成的字符串
     * @return 片段
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        int[] lastAppear = new int[26];
        int length = s.length();

        // 统计26个字母最后出现的下标
        for (int i = 0; i < length; i++) {
            lastAppear[s.charAt(i) - 'a'] = i;
        }

        // 上一段的最后一个元素下标
        int lastIdx = -1;
        int partitionIdx = 0;

        for (int i = 0; i < length; i++) {
            partitionIdx = Integer.max(partitionIdx, lastAppear[s.charAt(i) - 'a']);

            if (partitionIdx == i) {
                // 与当前位置重合，切分
                result.add(i - lastIdx);
                lastIdx = i;
            }
        }

        return result;
    }
}
