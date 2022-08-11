package com.ivan.l_22_08_11.s242;

import java.util.HashMap;

/**
 * @author Maximilian_Li
 */
public class s242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> fromS = new HashMap<>();
        HashMap<Character, Integer> fromT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            fromS.put(c, fromS.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            fromT.put(c, fromT.getOrDefault(c, 0) + 1);
        }

        System.out.println("fromS = " + fromS);
        System.out.println("fromT = " + fromT);

        return fromS.equals(fromT);
    }
}
