package com.ivan.l_22_08_16.s151;

/**
 * @author Maximilian_Li
 */
public class s151 {
    public String reverseWords(String s) {
        // 按照至少一个空格拆分字符串
        String[] t = s.split("\\s+");
        StringBuilder b = new StringBuilder();
        int left = 0, right = t.length - 1;

        while (left < right) {
            String temp = t[left];
            t[left] = t[right];
            t[right] = temp;
            left++;
            right--;
        }

        for (String str : t) {
            b.append(str).append(" ");
        }

        return b.toString().trim();
    }
}
