package com.lu;

public class Leet43 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];

        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i];
            if(dp[i-1] > 0)
                dp[i] += dp[i-1];
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Leet43().maxSubArray(nums));
    }
}
