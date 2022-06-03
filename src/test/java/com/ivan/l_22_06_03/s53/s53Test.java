package com.ivan.l_22_06_03.s53;

import junit.framework.TestCase;

public class s53Test extends TestCase {
    private s53 s53 = new s53();

    public void test() {
        int[] nums1 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = new int[]{1};
        int[] nums3 = new int[]{5, 4, -1, 7, 8};
        int res1 = s53.maxSubArray(nums1);
        int res2 = s53.maxSubArray(nums2);
        int res3 = s53.maxSubArray(nums3);
        System.out.println("res1 = " + res1);
        System.out.println("res2 = " + res2);
        System.out.println("res3 = " + res3);
    }
}