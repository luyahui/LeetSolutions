package com.lu;

public class Leet42 {
    static class Solution {
        public int trap(int[] height) {
            int result = 0;
            int highest = 0, index = 0;
            for(int i = 0; i < height.length; i++){
                if(height[i] > highest){
                    highest = height[i];
                    index = i;
                }
            }

            int lh = 0;
            for(int i = 0; i < index; i++){
                lh = Math.max(lh, height[i]);
                result += lh - height[i];
            }

            int rh = 0;
            for(int i = height.length-1; i > index; i--){
                rh = Math.max(rh, height[i]);
                result += rh - height[i];
            }

            return result;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
