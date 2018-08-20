package com.lu;

public class Leet152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp_max = new int[nums.length];
        int[] dp_min = new int[nums.length];
        dp_max[0] = nums[0];
        dp_min[0] = nums[0];
        int result = dp_max[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dp_max[i] = Math.max(nums[i] * dp_max[i - 1], nums[i]);
                dp_min[i] = Math.min(nums[i] * dp_min[i - 1], nums[i]);
            } else {
                dp_max[i] = Math.max(nums[i] * dp_min[i - 1], nums[i]);
                dp_min[i] = Math.min(nums[i] * dp_max[i - 1], nums[i]);
            }

            result = Math.max(result, dp_max[i]);
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(new Leet152().maxProduct(nums));
    }
}
