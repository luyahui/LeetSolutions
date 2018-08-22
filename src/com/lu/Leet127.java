package com.lu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet127 {
    static class Solution {
        private int wordDifference(String word1, String word2){
            int result = 0;
            for(int i = 0; i < word1.length(); i++)
                result += word1.charAt(i) == word2.charAt(i) ? 0 : 1;
            return result;
        }

        private int helper(String beginWord, String endWord, Set<String> wordSet){
            if(!wordSet.contains(endWord))
                return 0;
            List<String> words = new ArrayList<>();

            for(String word : wordSet){
                if(wordDifference(beginWord, word) != 1)
                    continue;
                if(word == endWord)
                    return 2;
                words.add(word);
            }

            wordSet.removeAll(words);

            for(String word : words){
                int temp = helper(word, endWord, wordSet);
                if(temp > 0)
                    return temp+1;
            }

            return 0;

        }

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> set = new HashSet<>(wordList);
            return helper(beginWord, endWord, set);
        }
    }

    public static void main(String[] args){
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>();
        String[] words = new String[]{"hot","dot","dog","lot","log","cog"};
        for(String word:words)
            wordList.add(word);
        System.out.println(new Solution().ladderLength(beginWord, endWord, wordList));
    }
}
