package com.lu;

import java.util.*;

public class Leet403 {

    static class Solution {

        private boolean tryJump(int[] stones, int pos, int step, Map<Integer, Set<Integer>> failureMap){
            if(pos >= stones.length - 1)
                return true;

            if(failureMap.containsKey(pos) && failureMap.get(pos).contains(step))
                return false;

            int nearest = stones[pos] + step - 1, farest = stones[pos] + step + 1;

            for(int j = pos + 1; j < stones.length; j++){
                if(stones[j] < nearest)
                    continue;
                if(stones[j] > farest)
                    break;
                if(tryJump(stones, j, stones[j] - stones[pos], failureMap))
                    return true;
            }

            if(!failureMap.containsKey(pos))
                failureMap.put(pos, new HashSet<Integer>());
            failureMap.get(pos).add(step);

            return false;

        }
        public boolean canCross(int[] stones) {
            Map<Integer, Set<Integer>> failureMap = new HashMap<>();
            return tryJump(stones, 0, 0, failureMap);
        }
    }

    public static void main(String[] args) {
        int[] stones = new int[]{0,1,3,6,10,13,15,16,19,21,25};
        Solution solution = new Solution();
        System.out.println(solution.canCross(stones));
    }
}
