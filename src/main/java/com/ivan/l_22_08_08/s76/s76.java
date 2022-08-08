package com.ivan.l_22_08_08.s76;

import java.util.HashMap;

/**
 * @author Maximilian_Li
 */
public class s76 {
    /**
     * 最小覆盖字串
     *
     * @param s 大范围
     * @param t 小范围
     * @return 最小覆盖字串
     */
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();

        char[] cs1 = t.toCharArray();
        char[] cs2 = s.toCharArray();

        // 将所需字符放入need映射
        for (char ch : cs1) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        // 处理大范围字符串
        int left = 0, right = 0;
        int valid = 0;
        // 最小覆盖字串起始索引与长度
        int start = 0, len = Integer.MAX_VALUE;

        while (right < cs2.length) {
            char r = cs2[right++];
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).equals(need.get(r))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                // 更新最小覆盖字串长度
                if (len > right - left) {
                    start = left;
                    len = right - left;
                }

                char l = cs2[left++];
                if (need.containsKey(l)) {
                    if (window.get(l).equals(need.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len - 1);
    }
}
