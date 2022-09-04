package com.ivan.l_22_09_04.s17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s17 {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    String[] cat = new String[]{
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        bt(digits.length(), digits, 0);
        return res;
    }

    public void bt(int volume, String digits, int ptr) {
        // 结束条件
        if (path.length() == volume) {
            res.add(path.toString());
            return;
        }

        // 选择:一行中的每个字符  in  选择列表:一行
        String letters = cat[Integer.parseInt(String.valueOf(digits.charAt(ptr)))];
        for (int i = 0; i < letters.length(); i++) {
            // do
            path.append(letters.charAt(i));
            // bt
            bt(volume, digits, ptr + 1);
            // cancel
            path.deleteCharAt(path.length() - 1);
        }
    }
}
