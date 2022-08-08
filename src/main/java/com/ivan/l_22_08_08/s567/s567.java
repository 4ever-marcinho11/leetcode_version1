package com.ivan.l_22_08_08.s567;

import java.util.HashMap;

/**
 * @author Maximilian_Li
 */
public class s567 {
    /**
     * 找s2中上是否有s1的排列
     *
     * @param s1 小范围
     * @param s2 大范围
     * @return boolean
     */
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();

        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();

        // 将所需字符放入need映射
        for (char ch : cs1) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        // 处理大范围字符串
        int left = 0, right = 0;
        int valid = 0;

        while (right < cs2.length) {
            // 先处理右侧边界，并右移窗口
            char r = cs2[right++];
            if (need.containsKey(r)) {
                // 先更新window中的数据
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).equals(need.get(r))) {
                    // 放后若数量相同，将valid自增
                    valid++;
                }
            }

            // 再处理左侧边界，并左移窗口
            while (right - left >= cs1.length) {
                // 判断是否符合，符合返回true
                if (valid == need.size()) {
                    return true;
                }

                char l = cs2[left++];
                if (need.containsKey(l)) {
                    // 先判断数量，若相同则将valid自减
                    if (window.get(l).equals(need.get(l))) {
                        valid--;
                    }
                    // 再更新window中的数据
                    window.put(l, window.get(l) - 1);
                }
            }
        }

        return false;
    }
}
