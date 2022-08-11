package com.ivan.l_22_08_11.s349;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Maximilian_Li
 */
public class s349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (Integer i : nums1) {
            map.put(i, 0);
        }

        for (Integer i : nums2) {
            if (map.containsKey(i) && !res.contains(i)) {
                res.add(i);
            }
        }

        return res.stream().mapToInt((one) -> {
            return one;
        }).toArray();
    }
}
