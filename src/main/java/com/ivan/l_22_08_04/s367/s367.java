package com.ivan.l_22_08_04.s367;

public class s367 {
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid > num) {
                right = mid - 1;
            } else if ((long) mid * mid < num) {
                left = mid + 1;
            } else if ((long) mid * mid == num) {
                return true;
            }
        }

        return false;
    }
}
