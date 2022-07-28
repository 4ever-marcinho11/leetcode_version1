package com.ivan.l_22_07_28.s1331;

import java.util.Arrays;
import java.util.HashMap;

public class s1331 {
    public int[] arrayRankTransform(int[] arr) {
        // 排序
        int[] ordered = new int[arr.length];
        ordered = Arrays.stream(arr).map((one) -> {
            return one;
        }).toArray();
        Arrays.sort(ordered);

        // 哈希映射
        int rank = 1;
        HashMap<Integer, Integer> mapper = new HashMap<>();
        for (int one : ordered) {
            if (mapper.containsKey(one)) {
                continue;
            }
            mapper.put(one, rank++);
        }

        // 得到结果
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = mapper.get(arr[i]);
        }

        return result;
    }
}
