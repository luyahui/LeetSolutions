package com.lu;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Leet15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // int current = nums[i];
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int low = i + 1, high = nums.length - 1;

            while (low < high) {
                int current = nums[i] + nums[low] + nums[high];
                if (current == 0) {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[i]);
                    lst.add(nums[low]);
                    lst.add(nums[high]);
                    result.add(lst);
                    while (nums[low + 1] == nums[low] && low < high - 1)
                        low++;
                    low++;
                    while (nums[high - 1] == nums[high] && high > low + 1)
                        high--;
                    high--;
                } else if (current > 0) {
                    high--;
                } else
                    low++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Leet15 l15 = new Leet15();
        System.out.println(l15.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
