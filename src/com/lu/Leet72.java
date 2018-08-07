package com.lu;

public class Leet72 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {

                } else {

                }
            }
        }

        return dp[word1.length() - 1][word2.length() - 1];
    }
}
