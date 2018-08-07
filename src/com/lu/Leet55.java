package com.lu;

public class Leet55 {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1)
            return true;
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }


        return dp[0];
    }

    public static void main(String[] args) {
        Leet55 l55 = new Leet55();
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(l55.canJump(nums));
    }
}
