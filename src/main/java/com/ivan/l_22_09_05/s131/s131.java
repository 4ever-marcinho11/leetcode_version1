package com.ivan.l_22_09_05.s131;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s131 {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        bt(0, s);
        return res;
    }

    public void bt(int indexOfLastSaved, String str) {
        if (indexOfLastSaved >= str.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = indexOfLastSaved; i <= str.length() - 1; i++) {
            if (isPalindrome(str, indexOfLastSaved, i)) {
                String ele = str.substring(indexOfLastSaved, i + 1);
                path.add(ele);
            } else {
                continue;
            }
            bt(i + 1, str);
            path.removeLast();
        }
    }

    public boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
