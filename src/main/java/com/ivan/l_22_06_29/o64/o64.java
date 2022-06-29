package com.ivan.l_22_06_29.o64;

public class o64 {
    public int sumNums(int n) {
        //不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
        if (n == 0) {
            return 0;
        }

        return n + sumNums(n - 1);
    }
}
