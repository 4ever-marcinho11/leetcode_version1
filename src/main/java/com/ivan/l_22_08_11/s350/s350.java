package com.ivan.l_22_08_11.s350;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Maximilian_Li
 */
public class s350 {
    /**
     * 按照交集数字出现的数目（不同的情况下考虑取较小值）返回
     *
     * @param nums1 定义为短数组
     * @param nums2 定义为长数组
     * @return 交集数组
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (Integer i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Integer i : nums2) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) {
                    map.remove(i);
                }
                res.add(i);
            }
        }

        return res.stream().mapToInt((one) -> {
            return one;
        }).toArray();
    }
}
