package com.lu;

public class Leet33 {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] == target)
                return middle;
            if (nums[middle] < target) {
                if (nums[high] < nums[middle])
                    low = middle + 1;
                else if (nums[high] >= target)
                    low = middle + 1;
                else
                    high = middle - 1;
            } else {
                if (nums[low] > nums[middle])
                    high = middle - 1;
                else if (nums[low] <= target)
                    high = middle - 1;
                else
                    low = middle + 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(new Leet33().search(nums, 8));
    }
}
