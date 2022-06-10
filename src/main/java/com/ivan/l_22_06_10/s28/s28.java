package com.ivan.l_22_06_10.s28;

import java.util.Arrays;

public class s28 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0 || haystack == null) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        // 得到模式串的前缀表
        int[] next = new int[needle.length()];
        Arrays.fill(next, 0);
        for (int i = 1; i < needle.length(); i++) {
            // 在该字符之前的子串的最长前缀后缀长度
            int baseLength = next[i - 1];
             /*
             为什么用当前字符与needle.charAt(baseLength)这个字符进行比较呢？
             因为在当前字符前的子串中，最长前缀后缀长度是baseLength，
             说明前baseLength个字符已经被证明是这个字串的最长前缀后缀长度，只需要跳过这几个字符
             那需要被当前字符比较的是下标为baseLength的字符（就是上面说的"跳过"）
             */
            if (needle.charAt(baseLength) == needle.charAt(i)) {
                // 相等，直接在原有的最长长度上加1
                next[i] = baseLength + 1;
            } else {
                // 不等，不能直接赋0
                if (baseLength == 0) {
                    baseLength = 1;
                }
                // 找第baseLength个字符的前一个字符对应的最长长度
                int len = next[baseLength - 1];
                // 跳过这个长度，用当前字符与跳过后的第一个字符进行比较
                if (needle.charAt(len) == needle.charAt(i)) {
                    // 相等的话在这个长度上加1
                    next[i] = len + 1;
                }
            }
        }
        System.out.println("模式串的前缀表是: " + Arrays.toString(next));
        System.out.println("------------------");

        // KMP模式匹配，haystack是文本串，needle是模式串
        int i = 0, j = 0;
        while (j < needle.length() && i < haystack.length()) {
            System.out.println(haystack + " 的第 " + (i + 1) + " 位是" + haystack.charAt(i));
            System.out.println(needle + " 的第 " + (j + 1) + " 位是" + needle.charAt(j));
            if (haystack.charAt(i) == needle.charAt(j)) {
                System.out.println("这两个位置相等，同时前移1位");
                i++;
                j++;
            } else {
                System.out.print("这两个位置不等，");
                if (j == 0) {
                    System.out.println("j为0，i前移1位");
                    i++;
                } else {
                    System.out.println("j移动到 " + next[j - 1]);
                    j = next[j - 1];
                }
            }
            System.out.println("--------------");
        }

        if (i == haystack.length() && j < needle.length()) {
            return -1;
        }
        return i - j;
    }
}
