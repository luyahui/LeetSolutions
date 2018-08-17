package com.lu;

import java.util.ArrayList;
import java.util.List;

public class Leet300 {
    public int lengthOfLIS(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int low = 0, high = result.size()-1;
            int pos = -1;
            while(low <= high){
                int middle = low + (high - low) / 2;
                if(num == result.get(middle)){
                    pos = middle;
                    break;
                }
                if(num > result.get(middle)){
                    low = middle + 1;
                    continue;
                }
                else
                    high = middle - 1;
            }
            if(pos != -1)
                continue;
            if(low >= result.size())
                result.add(num);
            else
                result.set(low, num);
        }

        return result.size();
    }

    public static void main(String[] args){
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        Leet300 l300 = new Leet300();
        System.out.println(l300.lengthOfLIS(nums));
    }
}

