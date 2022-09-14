package com.ivan.l_22_09_14.s1005;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Maximilian_Li
 */
public class s1005 {

    /**
     * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
     * <p>
     * 选择某个下标 i并将 nums[i] 替换为 -nums[i] 。
     * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
     * <p>
     * 以这种方式修改数组后，返回数组 可能的最大和 。
     *
     * @param nums 整数数组
     * @param k    重复次数
     * @return 最大和
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 按照绝对值大小排序
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, Comparator.comparingInt(Math::abs));

        // 首先从最大的一端开始将负数转正
        int size = arr.length;
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] < 0 && k > 0) {
                arr[i] = -arr[i];
                k--;
            }
        }

        // 如果负数都变为正，但还需要转换的话，从最小的一端进行转换
        if (k % 2 == 1) {
            arr[0] = -arr[0];
        }

        int res = 0;
        for (int i : arr) {
            res += i;
        }
        return res;
    }
}
