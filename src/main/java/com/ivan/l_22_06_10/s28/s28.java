package com.ivan.l_22_06_10.s28;

public class s28 {
    /**
     * 使用不减一的next数组实现kmp算法
     *
     * @param haystack 文本串
     * @param needle   模式串
     * @return 返回模式串在文本串中出现的第一个位置，如果不存在就返回-1
     */
    public int strStr(String haystack, String needle) {
        // 预操作
        if (needle.length() == 0) {
            return 0;
        }

        // 生成next数组
        int[] next = new int[needle.length()];
        generateNextArr(next, needle);

        // kmp
        return findFirstIdx(next, haystack, needle);
    }

    private void generateNextArr(int[] next, String needle) {
        for (int i = 1; i < needle.length(); i++) {
            // 这个时候还没有确定以模式串[i]为结尾的字符串的最长相同前后缀
            // 因此先获取不包括该字符的字符串的最长相同前后缀长度
            int j = next[i - 1];

            // str.charAt(x)也可以被想做：跳过str的前x个字符，得到下一个字符
            if (needle.charAt(j) == needle.charAt(i)) {
                // 当前元素与跳过后的下一个字符相等，直接在原有的最长长度上加1
                next[i] = j + 1;
            } else {
                /*
                一个字符只有以下三种情况
                1. 被前面的最长相等前后缀包括：x+1
                2. 1
                3. 0
                 */
                // 现在已经排除了上面的第一种情况，那就没必要再看中间夹着的字符了
                int len = (j == 0) ? next[0] : next[j - 1];
                if (needle.charAt(len) == needle.charAt(i)) {
                    // 相等的话，符合第二种情况，在这个长度上加1
                    next[i] = len + 1;
                }
            }
        }
    }

    private int findFirstIdx(int[] next, String haystack, String needle) {
        int i = 0, j = 0;
        while (j < needle.length() && i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                // 文本串[i]与模式串[j]相等，直接跳过这俩字符
                i++;
                j++;
            } else {
                if (j == 0) {
                    // 与模式串的第一个就不等，模式串没法往前回溯，要让文本串指针后移一位，从后面找
                    i++;
                } else {
                    // 模式串往前回溯
                    j = next[j - 1];
                }
            }
        }

        if (i == haystack.length() && j < needle.length()) {
            return -1;
        }
        return i - j;
    }
}
