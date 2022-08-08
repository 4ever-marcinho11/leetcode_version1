package com.ivan.l_22_08_08.s438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class s438 {
    /**
     * 找到字符串中所有字母异位词
     *
     * @param s 大范围
     * @param p 小范围
     * @return 索引集
     */
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();

        char[] cs1 = p.toCharArray();
        char[] cs2 = s.toCharArray();

        for (char ch : cs1) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;
        List<Integer> res = new ArrayList<>();

        while (right < cs2.length) {
            char r = cs2[right++];
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).equals(need.get(r))) {
                    valid++;
                }
            }

            while (right - left >= cs1.length) {
                // 添加索引
                if (valid == need.size()) {
                    res.add(left);
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

        return res;
    }
}
