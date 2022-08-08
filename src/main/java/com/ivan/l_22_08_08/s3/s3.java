package com.ivan.l_22_08_08.s3;

import java.util.HashMap;

/**
 * @author Maximilian_Li
 */
public class s3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        char[] cs = s.toCharArray();
        int res = 0;

        while (right < cs.length) {
            char r = cs[right++];
            // 直接放，因为只允许有一个
            window.put(r, window.getOrDefault(r, 0) + 1);

            while (window.get(r) > 1) {
                char l = cs[left++];
                window.put(l, window.get(l) - 1);
            }
            res = Math.max(res, right - left);
        }

        return res;
    }
}
