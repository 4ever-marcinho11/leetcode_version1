package com.ivan.l_22_08_01.s35;

import junit.framework.TestCase;

public class s35Test extends TestCase {
    private final s35 s = new s35();

    public void test() {
        int[] arr = new int[]{1, 3, 5, 6};
        int tar = 7;

        int result = s.searchInsert(arr, tar);
        System.out.println("result = " + result);
    }
}