package com.ivan.l_22_08_03.s4;

public class s4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenOf1 = nums1.length;
        int lenOf2 = nums2.length;
        int kTh = (lenOf1 + lenOf2 + 1) / 2;
        int kPlus1Th = (lenOf1 + lenOf2) / 2 + 1;

        int resOfK = findKth(nums1, nums2, 0, lenOf1 - 1, 0, lenOf2 - 1, kTh);
        int resOfkPlus1 = findKth(nums1, nums2, 0, lenOf1 - 1, 0, lenOf2 - 1, kPlus1Th);
        return 0.5 * (resOfK + resOfkPlus1);
    }

    /**
     * 在指定范围两个数组中使用二分的思想寻找第k小的数字
     *
     * @param a1 数组1
     * @param a2 数组2
     * @param s1 数组1的起始索引
     * @param e1 数组1的中止索引
     * @param s2 数组2的起始索引
     * @param e2 数组2的中止索引
     * @param k  第k小
     */
    public int findKth(int[] a1, int[] a2, int s1, int e1, int s2, int e2, int k) {
        // 两个数组长度
        int lenOf1 = e1 - s1 + 1;
        int lenOf2 = e2 - s2 + 1;

        // 保证两个数组并列排在一起时，上面的长度不长于下面的长度
        if (lenOf1 > lenOf2) {
            return findKth(a2, a1, s2, e2, s1, e1, k);
        }

        // 上面的数组已经全被排除: 直接找下面数组的第k个
        if (lenOf1 == 0) {
            return a2[s2 + k - 1];
        }

        // 找第1小的数字: 两个起始数字中更小的那个
        if (k == 1) {
            return Math.min(a1[s1], a2[s2]);
        }

        // 各在两个数组找k/2个, 对两个第k/2个元素进行比较, 小的及对应数组之前的决不可能成为答案
        // 如果k/2超出范围, 则用最后一个替代Math.min(k / 2, len)
        int idx1 = s1 + Math.min(k / 2, lenOf1) - 1;
        int idx2 = s2 + Math.min(k / 2, lenOf2) - 1;

        if (a1[idx1] > a2[idx2]) {
            // 排除a2中s2到idx2
            int dismissed = idx2 - s2 + 1;
            return findKth(a1, a2, s1, e1, idx2 + 1, e2, k - dismissed);
        } else {
            // 排除a1中s1到idx1
            int dismissed = idx1 - s1 + 1;
            return findKth(a1, a2, idx1 + 1, e1, s2, e2, k - dismissed);
        }
    }
}
