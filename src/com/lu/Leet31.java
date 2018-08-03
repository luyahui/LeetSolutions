package com.lu;

public class Leet31 {
    public void nextPermutation(int[] nums) {
        int low = 0, high = nums.length - 1;
        int p1 = nums.length - 1;
        for (; p1 > 0 && nums[p1] <= nums[p1 - 1]; p1--) {
        }

        if (p1 != 0) {
            p1--;
            int p2 = p1 + 1;
            while (p2 < nums.length && nums[p2] > nums[p1])
                p2++;
            p2--;

            int temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;

            low = p1 + 1;
        }

        while (low < high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 1};
        new Leet31().nextPermutation(nums);
        System.out.println(nums);
    }
}
