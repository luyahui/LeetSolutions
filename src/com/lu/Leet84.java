package com.lu;

public class Leet84 {
    static class Solution {
        public int largestRectangleArea(int[] heights) {
            int[][] minimum = new int[heights.length][heights.length];

            for(int i = 0; i < heights.length; i++){
                minimum[i][i] = heights[i];
            }

            for(int i = 0; i < heights.length; i++){
                for(int j = i+1; j < heights.length; j++)
                    minimum[i][j] = Math.min(minimum[i][j-1], heights[j]);
            }

            int result = 0;
            for(int i = 0; i < heights.length; i++){
                for(int j = 0; j <= i; j++){
                    result = Math.max(result, (i-j+1) * minimum[j][i]);
                }
            }

            return result;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
