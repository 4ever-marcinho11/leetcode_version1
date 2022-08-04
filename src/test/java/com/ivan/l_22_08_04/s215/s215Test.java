package com.ivan.l_22_08_04.s215;

import junit.framework.TestCase;

public class s215Test extends TestCase {
    private final s215 s = new s215();

    public void test() {
        int[] array = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int kthLargest = s.quickSort(array, k);
        System.out.println("kthLargest = " + kthLargest);
    }
}