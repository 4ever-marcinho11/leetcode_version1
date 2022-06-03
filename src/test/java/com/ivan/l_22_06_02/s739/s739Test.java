package com.ivan.l_22_06_02.s739;

import junit.framework.TestCase;

import java.util.Arrays;

public class s739Test extends TestCase {
    private s739 s739 = new s739();

    public void test() {
        int[] t = new int[]{30, 60, 90};
        int[] res = s739.dailyTemperatures(t);
        System.out.println("res = " + Arrays.toString(res));
    }
}