package com.ivan.l_22_08_03.s11;

public class s11 {
    public int maxArea(int[] height) {
        // 盛水量: 两线横轴之差 * 两线间更短的那条线的长度
        int left = 0, right = height.length - 1;
        int volume = 0;

        while (left < right) {
            // 计算容积, 并与之前的结果作比较
            volume = Math.max(volume, (right - left) * Math.min(height[left], height[right]));
            // 为下一次计算做准备: 不能再包含短边了
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return volume;
    }
}
