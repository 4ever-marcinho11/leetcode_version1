package com.ivan.l_22_10_07.s416;

import junit.framework.TestCase;
import org.junit.Test;

public class s416Test extends TestCase {
    private final s416 s416 = new s416();

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 5};
        System.out.println("can? = " + s416.canPartition(nums));
    }
}