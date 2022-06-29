package com.ivan.l_22_06_29.s202;

public class s202 {
    /**
     * 使用快慢指针的方式计算快乐数
     * 因为快指针的平方和永远在某一时刻会等于慢指针的平方和
     */
    public boolean isHappy(int n) {
        int fast = n, slow = n;

        do {
            fast = afterWhile(fast);
            fast = afterWhile(fast);
            slow = afterWhile(slow);
        } while (fast != slow);

        return fast == 1;
    }

    /**
     * 计算数字n的各位数字平方和
     */
    public int afterWhile(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
