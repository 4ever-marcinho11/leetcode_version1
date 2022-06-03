package com.ivan.l_22_05_30.s503;

import junit.framework.TestCase;

import java.util.Arrays;

public class s503Test extends TestCase {
    private s503 s503 = new s503();

    public void test() {
        int[] nums = new int[]{1, 2, 3, 4, 3};
        int[] res = s503.nextGreaterElements(nums);
        System.out.println("res = " + Arrays.toString(res));
    }
}