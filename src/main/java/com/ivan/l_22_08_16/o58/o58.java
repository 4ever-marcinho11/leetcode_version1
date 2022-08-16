package com.ivan.l_22_08_16.o58;

/**
 * @author Maximilian_Li
 */
public class o58 {
    public String reverseLeftWords(String s, int n) {
        if (s.length() == 1) {
            return s;
        }

        if (n == 0 || n % s.length() == 0) {
            // 不需要旋转 || 旋转后也是原字符串
            return s;
        }

        // 使n在 0 <= n < length 中
        n %= s.length();

        char[] t = s.toCharArray();
        // 反转前n个
        swap(t, 0, n - 1);
        // 反转其他的
        swap(t, n, t.length - 1);
        // 反转全部
        swap(t, 0, t.length - 1);

        return String.valueOf(t);
    }

    private void swap(char[] t, int start, int end) {
        int left = start, right = end;

        while (left < right) {
            char temp = t[left];
            t[left] = t[right];
            t[right] = temp;
            left++;
            right--;
        }
    }
}
