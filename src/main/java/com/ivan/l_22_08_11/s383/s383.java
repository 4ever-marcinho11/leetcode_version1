package com.ivan.l_22_08_11.s383;

import java.util.HashMap;

/**
 * @author Maximilian_Li
 */
public class s383 {
    /**
     * 判断ransomNote能否由magazine中的字符构成
     *
     * @param ransomNote 小范围
     * @param magazine   大范围
     * @return 是否能
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
                if (map.get(c) < 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
