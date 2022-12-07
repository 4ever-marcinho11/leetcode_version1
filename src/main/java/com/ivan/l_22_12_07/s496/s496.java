package com.ivan.l_22_12_07.s496;

import java.util.Deque;
import java.util.LinkedList;

public class s496 {
    /**
     * nums1中数字x的 下一个更大元素 是指x在nums2 中对应位置 右侧 的 第一个 比x大的元素。
     * <p>
     * 给你两个 没有重复元素 的数组nums1 和nums2 ，下标从 0 开始计数，其中nums1是nums2的子集。
     * <p>
     * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。
     * <p>
     * 如果不存在下一个更大元素，那么本次查询的答案是 -1 。
     *
     * @param nums1 没有重复元素 的数组nums1
     * @param nums2 没有重复元素 的数组nums2
     * @return 返回一个长度为nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans1 = new int[nums1.length];
        int[] ans2 = new int[nums2.length];

        Deque<Integer> d2 = new LinkedList<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!d2.isEmpty() && d2.getLast() <= nums2[i]) {
                d2.removeLast();
            }

            ans2[i] = d2.isEmpty() ? -1 : d2.getLast();
            d2.addLast(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    ans1[i] = ans2[j];
                }
            }
        }

        return ans1;
    }
}
