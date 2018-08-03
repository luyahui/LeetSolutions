package com.lu;

import java.util.*;

public class Leet49 {
    private String getOrderedString(String str){
        char[] charset = str.toCharArray();
        Arrays.sort(charset);
        return String.valueOf(charset);
    }

    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for(String str:strs){
            if(!map.containsKey(getOrderedString(str))){
                map.put(getOrderedString(str),result.size());
                result.add(new ArrayList<String>());
            }
            result.get(map.get(getOrderedString(str))).add(str);
        }
        return result;
    }

    public static void main(String[] args){
        Leet49 l49 = new Leet49();
//        System.out.println(l49.getOrderedString("nbalfkl"));
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(l49.groupAnagrams(strings));
    }
}
