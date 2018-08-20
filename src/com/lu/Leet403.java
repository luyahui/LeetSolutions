package com.lu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet403 {

    private boolean tryJump(int[] stones, int pos, int step) {
        if (pos == stones.length - 1)
            return true;
        for (int i = pos + 1; i < stones.length; i++) {
            int distance = stones[i] - stones[pos];
            if (distance > step + 1)
                return false;
            if (distance < step - 1)
                continue;
            if (tryJump(stones, i, distance))
                return true;
        }
        return false;
    }

    public boolean canCross(int[] stones) {
        List<Integer>[] dp = new List[stones.length];
        for(int i = 0; i < stones.length; i++){
            dp[i] = new ArrayList<>();
        }
        dp[0].add(0);
        for(int i = 0; i < stones.length; i++){
            for(int step:dp[i]){
                int nearest = step-1, farest = + step + 1;
                for( int j = i+1; j < stones.length; j++){
                    int distance = stones[j] - stones[i];
                    if(distance < nearest)
                        continue;
                    if(distance > farest)
                        break;
                    dp[j].add(distance);
                }
            }
        }
        return dp[stones.length-1].size() > 0;
    }

    public static void main(String[] args) {
        Leet403 l403 = new Leet403();
        int[] stones = new int[]{0,1,3,5,6,8,12,17};
        System.out.println(l403.canCross(stones));
    }
}
