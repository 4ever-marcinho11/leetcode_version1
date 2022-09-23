package com.ivan.l_22_09_23.s738;

/**
 * @author Maximilian_Li
 */
public class s738 {
    /**
     * 当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。
     *
     * @param n 整数
     * @return 小于或等于 n 的，且呈 单调递增 的 最大数字
     */
    public int monotoneIncreasingDigits(int n) {
        // 位数为1的数字直接返回
        if (n / 10 == 0) {
            return n;
        }

        StringBuilder str = new StringBuilder(String.valueOf(n));
        int length = str.length();
        int at = length;
        for (int i = length - 1; i > 0; i--) {
            // 从后向前遍历，找到第一个非单调递增的位置
            if (str.charAt(i) < str.charAt(i - 1)) {
                at = i;
                int digit = Integer.parseInt(String.valueOf(str.charAt(i - 1)));
                str.replace(i - 1, i, String.valueOf(digit - 1));
            }
        }

        // 将第一个非单调递增的位置及之后对应的数字全部变成9
        for (int i = at; i < length; i++) {
            str.replace(i, i + 1, String.valueOf(9));
        }

        return Integer.parseInt(str.toString());
    }
}
