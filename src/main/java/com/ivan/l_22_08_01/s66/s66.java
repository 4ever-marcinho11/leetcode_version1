package com.ivan.l_22_08_01.s66;

public class s66 {
    public int[] plusOne(int[] digits) {
        if (digits[0] == 0) {
            return new int[]{1};
        }

        int digitsLen = digits.length;
        int[] plus = new int[digitsLen + 1];
        System.arraycopy(digits, 0, plus, 1, digitsLen);

        int flag = 0;
        for (int i = plus.length - 1; i >= 0; i--) {
            int sum;
            if (i == plus.length - 1) {
                sum = plus[i] + 1 + flag;
            } else {
                sum = plus[i] + flag;
            }
            if (sum < 10) {
                plus[i] = sum;
                break;
            } else {
                flag = sum / 10;
                plus[i] = sum % 10;
            }
        }

        if (plus[0] == 0) {
            System.arraycopy(plus, 1, digits, 0, plus.length - 1);
            return digits;
        }

        return plus;
    }

    public int[] addOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        // 退出循环，代表原数组全是9
        int[] more = new int[digits.length + 1];
        more[0] = 1;
        return more;
    }
}
