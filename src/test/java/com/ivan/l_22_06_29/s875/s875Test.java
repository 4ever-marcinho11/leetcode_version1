package com.ivan.l_22_06_29.s875;

import junit.framework.TestCase;

public class s875Test extends TestCase {
    private s875 s = new s875();

    public void test() {
        int[] piles = new int[]{30, 11, 23, 4, 20};
        int h = 5;
        System.out.println("min speed = " + s.minEatingSpeed(piles, h));
    }

}