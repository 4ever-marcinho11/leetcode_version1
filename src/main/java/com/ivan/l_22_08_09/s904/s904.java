package com.ivan.l_22_08_09.s904;

import java.util.HashMap;

/**
 * @author Maximilian_Li
 */
public class s904 {
    public int totalFruit(int[] fruits) {
        int left = 0, right = 0, res = 0, valid = 0;
        HashMap<Integer, Integer> window = new HashMap<>();

        while (right < fruits.length) {
            int r = fruits[right++];
            window.put(r, window.getOrDefault(r, 0) + 1);

            // 目前有三种树
            while (window.size() > 2) {
                int l = fruits[left++];
                window.put(l, window.get(l) - 1);
                if (window.get(l) == 0) {
                    window.remove(l);
                }
            }

            // 收缩完了再比较长短
            res = Math.max(res, right - left);
        }

        return res;
    }
}
