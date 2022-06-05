package com.ivan.l_22_06_05.s516;

import junit.framework.TestCase;

public class s516Test extends TestCase {
    private s516 s516 = new s516();

    public void test() {
        int res = s516.longestPalindromeSubseq("cbbd");
        System.out.println("res = " + res);
    }
}