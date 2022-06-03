package com.ivan.l_22_05_30.s496;

import junit.framework.TestCase;

import java.util.Arrays;

public class s496Test extends TestCase {
    private s496 s496 = new s496();

    public void test() {
        int[] nums1 = new int[]{2, 4};
        int[] nums2 = new int[]{1, 2, 3, 4};
        int[] res = s496.nextGreaterElement(nums1, nums2);
        System.out.println("res = " + Arrays.toString(res));
    }
}