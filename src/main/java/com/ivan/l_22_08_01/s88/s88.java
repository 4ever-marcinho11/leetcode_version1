package com.ivan.l_22_08_01.s88;

public class s88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m-- + n-- - 1;
        for (int i = idx; m >= 0 && n >= 0; i--) {
            int fromM = nums1[m];
            int fromN = nums2[n];

            if (fromM > fromN) {
                nums1[i] = fromM;
                m--;
            } else {
                nums1[i] = fromN;
                n--;
            }
        }

        if (n >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, n + 1);
        }
    }
}
