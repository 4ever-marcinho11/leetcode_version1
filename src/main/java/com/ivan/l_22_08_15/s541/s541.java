package com.ivan.l_22_08_15.s541;

/**
 * @author Maximilian_Li
 */
public class s541 {
    char[] chars = null;

    public String reverseStr(String s, int k) {
        chars = s.toCharArray();

        int left = 0, right = 0;
        while (right < chars.length) {
            if (right - left < 2 * k - 1) {
                if (right == chars.length - 1 && right - left < k - 1) {
                    // 如果剩余字符少于 k 个，则将剩余字符全部反转
                    swap(chars, left, right);
                    break;
                }
                if (right == chars.length - 1 && right - left >= k - 1) {
                    // 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样
                    swap(chars, left, left + k - 1);
                    break;
                }
                right++;
            }
            if (right - left == 2 * k - 1) {
                // 最普通情况
                swap(chars, left, left + k - 1);
                left = right + 1;
                right++;
            }
        }

        return new String(chars);
    }

    /**
     * 反转chars数组中索引为left到索引为right的字符
     *
     * @param chars 数组
     * @param left  左索引
     * @param right 右索引
     */
    private void swap(char[] chars, int left, int right) {
        int l = left, r = right;
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }
}
