package com.ivan.l_22_05_31.s556;

import java.math.BigDecimal;
import java.math.BigInteger;

public class s556 {
    public int nextGreaterElement(int n) {
        // 数字转数字字符串
        String s = n + "";
        String[] sarr = s.split("");
        int[] nums = new int[sarr.length];
        for (int i = 0; i < sarr.length; i++) {
            nums[i] = Integer.parseInt(sarr[i]);
        }

        if (1 <= n && n <= (int) (Math.pow(2, 31)) - 1) {
            // 下一个更大数字3
            int idx = nums.length - 2;
            while (idx >= 0 && nums[idx] >= nums[idx + 1]) {
                idx--;
            }

            if (idx >= 0) {
                int ptr = nums.length - 1;
                for (int i = ptr; i > idx; i--) {
                    if (nums[i] > nums[idx]) {
                        ptr = i;
                        break;
                    }
                }

                int temp = nums[idx];
                nums[idx] = nums[ptr];
                nums[ptr] = temp;

                int left = idx + 1, right = nums.length - 1;
                while (left < right) {
                    int t = nums[left];
                    nums[left] = nums[right];
                    nums[right] = t;
                    left++;
                    right--;
                }

                // 将结果从数组转化为数字
                int len = nums.length - 1;
                BigDecimal res = BigDecimal.ZERO;
                BigDecimal top = BigDecimal.valueOf(Math.pow(2, 31) - 1);
                for (int r : nums) {
                    res = res.add(BigDecimal.valueOf(r * Math.pow(10, len)));
                    len--;
                }

                BigInteger intVal = res.toBigInteger();
                if (intVal.compareTo(BigInteger.ONE) < 0 || intVal.compareTo(top.toBigInteger()) > 0) {
                    return -1;
                } else {
                    return intVal.intValue();
                }
            }
        }
        return -1;
    }
}
