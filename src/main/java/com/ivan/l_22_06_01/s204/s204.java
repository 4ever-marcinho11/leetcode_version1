package com.ivan.l_22_06_01.s204;

import java.util.Arrays;

public class s204 {
    public int countPrimes(int n) {
        // 返回所有小于非负整数n的质数的数量(从2开始)
        int count = 0;

        // false对应不是质数
        boolean[] arr = new boolean[n];
        Arrays.fill(arr, true);

        for (int i = 2; i < Math.sqrt(n); i++) {
            // 是质数，进入if，一系列数就不再计入考虑范围
            if (arr[i]) {
                for (int j = (int) Math.pow(i, 2); j < arr.length; j += i) {
                    arr[j] = false;
                }
            }
        }

        // 计数
        for (int i = 2; i < arr.length; i++) {
            if (arr[i]) {
                count++;
            }
        }

        return count;
    }

}
