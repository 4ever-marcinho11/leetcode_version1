package com.ivan.l_22_09_26.s509;

/**
 * @author Maximilian_Li
 */
public class s509 {
    /**
     * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
     * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和
     *
     * @param n 第n个斐波那契数
     * @return F(n)
     */
    public int fib(int n) {
        // 斐波那契数只与前两个数相关，因此数组大小设置为2即可
        int[] windows = new int[]{0, 1};

        // 有初始值，避免循环，节省资源
        if (n < 2) {
            return windows[n];
        }

        // 求n的斐波那契数只需要做n-1次操作
        for (int i = 2; i <= n; i++) {
            int sum = windows[0] + windows[1];
            windows[0] = windows[1];
            windows[1] = sum;
        }

        // windows[0]是F(n-1)
        return windows[1];
    }
}
