package com.ivan.l_22_06_01.s509;

public class s509 {
    public int fib(int n) {
        int[] window = new int[]{0, 1};
        for (int i = 0; i < n; i++) {
            int sum = window[0] + window[1];
            window[0] = window[1];
            window[1] = sum;
        }
        return window[0];
    }
}
