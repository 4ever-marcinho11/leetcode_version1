package com.ivan.l_22_05_29.s300;

import junit.framework.TestCase;
import org.junit.Test;

public class s300Test extends TestCase {
    private final s300 s300 = new s300();

    @Test
    public void testLb() {
        int[] a = new int[]{1, 3, 4, 5, 5, 5};
        int idx = s300.leftBs(a, 5);
        System.out.println("idx = " + idx);
    }

    @Test
    public void testMax() {
        int[] a = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int count = s300.maxUpUncontinuously(a);
        System.out.println("count = " + count);
    }
}