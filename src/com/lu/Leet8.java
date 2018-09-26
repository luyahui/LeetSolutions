package com.lu;

class Solution {
    public int myAtoi(String str) {
        String[] words = str.split(" ");
        String word = "";
        for(int i = 0; i < words.length; i++){
            if(words[i].length() > 0) {
                word = words[i];
                break;
            }
        }

        if(word == "")
            return 0;

        long res = 0;
        char ch = word.charAt(0);
        if(ch == '-' || ch-'9' <= 0){
            int flag = 1, i = 0;
            if(ch == '-'){
                flag = -1;
                i = 1;
            }
            for(;i < word.length(); i++){
                res = res * 10 + word.charAt(i) - '0';
                if(flag == 1 && res > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                else if(-1 * res < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
            res *= flag;
        }

        return (int)res;
    }
}

public class Leet8 {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("words and 987"));
    }
}
