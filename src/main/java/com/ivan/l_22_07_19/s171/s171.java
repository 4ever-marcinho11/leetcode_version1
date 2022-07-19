package com.ivan.l_22_07_19.s171;

import java.util.HashMap;

public class s171 {
    public int titleToNumber(String columnTitle) {
        // 将单个字母与在字母表中的位置(从1开始)置入哈希map中
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 1; i < 27; i++) {
            map.put((char) (i + 64), i);
        }

        // 求和
        int sum = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            // 每轮26个
            sum *= 26;
            sum += map.get(columnTitle.charAt(i));
        }

        return sum;
    }
}
