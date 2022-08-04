package com.ivan.l_22_08_04.s69;

public class s69 {
    public int mySqrt(int x) {
        int left = 0, right = x, res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x >= (long) mid * mid) {
                // mid小了
                left = mid + 1;
            } else if (x < (long) mid * mid) {
                // mid大了
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return right;
    }
}
