package com.ivan.l_22_07_30.s593;

import java.util.HashMap;

public class s593 {
    /**
     * 计算两点间距离^2
     *
     * @param d1 点1
     * @param d2 点2
     * @return 两点间距离^2
     */
    public static int cD2(int[] d1, int[] d2) {
        int deltaX = Math.abs(d1[0] - d2[0]);
        int deltaY = Math.abs(d1[1] - d2[1]);

        return deltaX * deltaX + deltaY * deltaY;
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashMap<Integer, Integer> mapper = new HashMap<>();

        int d1 = cD2(p1, p2);
        int d2 = cD2(p1, p3);
        int d3 = cD2(p1, p4);
        int d4 = cD2(p2, p3);
        int d5 = cD2(p2, p4);
        int d6 = cD2(p3, p4);

        mapper.put(d1, mapper.getOrDefault(d1, 0) + 1);
        mapper.put(d2, mapper.getOrDefault(d2, 0) + 1);
        mapper.put(d3, mapper.getOrDefault(d3, 0) + 1);
        mapper.put(d4, mapper.getOrDefault(d4, 0) + 1);
        mapper.put(d5, mapper.getOrDefault(d5, 0) + 1);
        mapper.put(d6, mapper.getOrDefault(d6, 0) + 1);

        return !mapper.containsKey(0) && mapper.size() == 2;
    }
}
