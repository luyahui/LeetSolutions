package com.lu;

public class Leet91 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for(int i = 0; i < s.length(); i++){
            int index = s.length() - 1 - i;
            if(s.charAt(index) == '0')
                continue;
            dp[i+1] += dp[i];
            if(i == 0)
                continue;

            if(Integer.parseInt(s.substring(index,index+2)) <= 26)
                dp[i+1] += dp[i-1];
        }
        return dp[s.length()];
    }

    public static void main(String[] args){
        Leet91 l91 = new Leet91();
        System.out.println(l91.numDecodings("226"));
    }
}
