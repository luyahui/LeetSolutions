package com.lu;

import java.util.*;

public class Leet127 {
    private int wordDifference(String word1, String word2){
        int result = 0;
        for(int i = 0; i < word1.length(); i++)
            result += word1.charAt(i) == word2.charAt(i) ? 0 : 1;
        return result;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == endWord)
            return 1;
        Map<Integer, Boolean> visited = new HashMap();
        for(int i = 0; i < wordList.size(); i++)
            visited.put(i, false);

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);

        int res = 1;
        while(beginSet.size() > 0){
            Set<String> nextSet = new HashSet();
            for(String each : beginSet){
                for(int i = 0; i < wordList.size(); i++){
                    if(visited.get(i))
                        continue;
                    if(wordDifference(each, wordList.get(i)) > 1)
                        continue;
                    if(wordList.get(i) == endWord)
                        return res+1;
                    nextSet.add(wordList.get(i));
                    visited.replace(i, true);
                }
            }
            res++;
            beginSet = nextSet;
        }

        return 0;
    }

    public static void main(String[] args){
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        Leet127 l127 = new Leet127();
        int len = l127.ladderLength("hit", "cog", wordList);
        System.out.println(len);
    }

}
