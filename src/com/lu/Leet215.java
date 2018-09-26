package com.lu;

public class Leet215 {
    private void swap(int[] nums, int pos1, int pos2){
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    private int findKthLargest(int[] nums, int start, int end, int k){
        if(start >= end)
            return nums[start];

        int pivotIndex = start + (end - start) / 2;
        int pivot = nums[pivotIndex];
        int left = start, right = end, count = 0;
        swap(nums, pivotIndex, right);
        right--;

        while(left <= right){
            if(nums[left] >= pivot && nums[right] < pivot){
                swap(nums, left, right);
                left++;
                right--;
                count++;
                continue;
            }
            if(nums[left] < pivot)
                left++;
            if(nums[right] >= pivot){
                right--;
                count++;
            }
        }

        if(count == k-1)
            return pivot;
        if(count > k-1)
            return findKthLargest(nums, end-count, end-1, k);
        return findKthLargest(nums, start, end-count-1, k-1-count);
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length-1, k);
    }

    public static void main(String[] args){
        System.out.println(new Leet215().findKthLargest(new int[]{2,1}, 2));
    }
}
