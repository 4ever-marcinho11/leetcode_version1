package com.ivan.l_22_06_30.s275;

public class s275 {
    public int hIndex(int[] citations) {
        // 搜索左边界的二分搜索
        int left = 0, right = citations.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= citations.length - mid) {
                // 收缩右边界，继续找左边界
                right = mid - 1;
            } else {
                // 收缩左边界
                left = mid + 1;
            }
        }

        // 不要返回left，要返回的是有几个符合条件
        return citations.length - left;
    }
}
