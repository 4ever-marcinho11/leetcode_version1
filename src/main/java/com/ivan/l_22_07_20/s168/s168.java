package com.ivan.l_22_07_20.s168;

import java.util.HashMap;

public class s168 {
    public String convertToTitle(int columnNumber) {
        // 将单个字母与在字母表中的位置(从0开始)置入哈希map中
        HashMap<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(i, (char) (i + 65));
        }

        // 拆数
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            // 从0开始
            columnNumber -= 1;
            // 组装
            sb.append(map.get(columnNumber % 26));
            // 重置
            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }
}
