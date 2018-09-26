package com.lu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leet611 {
    private boolean isValidTriangle(List<Integer> nums){
        if(nums.size() != 3)
            return false;
        List<Integer> array = new ArrayList<>(nums);
        Collections.sort(array);
        int num1 = array.get(0), num2 = array.get(1), num3 = array.get(2);
        return num1 + num2 > num3;
    }

    private void backtrack(int[] nums, int pos, List<Integer> current, int[] result){

        if(current.size() == 3){
            if(isValidTriangle(current))
                result[0]++;
            return;
        }
        if(pos >= nums.length)
            return;
        current.add(nums[pos]);
        backtrack(nums, pos+1, current, result);
        current.remove(current.size()-1);
        backtrack(nums, pos+1, current, result);
    }
    public int triangleNumber(int[] nums) {
        int[] result = new int[]{0};
        List<Integer> current = new ArrayList<>();
        backtrack(nums, 0, current, result);
        return result[0];
    }

    public static void main(String[] args){
        Leet611 leet611 = new Leet611();
        System.out.println(leet611.triangleNumber(new int[]{48,66,61,46,94,75}));
    }
}
