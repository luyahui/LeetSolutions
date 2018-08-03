package com.lu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet22 {
    private List<String> backtrack(int level, int totalLevel, List<String> prev) {
        if (level > totalLevel)
            return prev;
        Set<String> current = new HashSet<>();
        for (String str : prev) {
            for (int i = 0; i < str.length(); i++) {
                String temp = str.substring(0, i) + "()" + str.substring(i, str.length());
                current.add(temp);
            }
        }
        return backtrack(level + 1, totalLevel, new ArrayList<>(current));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0)
            return result;
        result.add("()");

        return backtrack(2, n, result);
    }

    public static void main(String[] args) {
        Leet22 l22 = new Leet22();
        System.out.println(l22.generateParenthesis(4));
    }
}
