package com.lu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet17 {
    private void backtrack(Map<Character, String> map, String digits, int level, String current, List<String> result) {
        if (level == digits.length())
            result.add(current);
        else {
            String nexts = map.get(digits.charAt(level));
            for (int i = 0; i < nexts.length(); i++) {
                backtrack(map, digits, level + 1, current + nexts.charAt(i), result);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        backtrack(map, digits, 0, "", result);

        return result;
    }

    public static void main(String[] args){
        Leet17 l17 = new Leet17();
        System.out.println(l17.letterCombinations("23"));
    }
}
