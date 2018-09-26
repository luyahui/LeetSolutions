package com.lu;

public class Leet4 {
    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int pos1 = 0, pos2 = 0;
        int count1 = -1, count2 = -1;
        int num1 = 0, num2 = 0;
        int totalCount = nums1.length + nums2.length;
        if(totalCount % 2 == 1){
            count1 = totalCount / 2 + 1;
            count2 = count1;
        }
        else{
            count1 = totalCount / 2;
            count2 = count1 + 1;
        }

        int i = 0, temp = 0;
        while (i <= count1 || i <= count2){
            if(i == count1)
                num1 = temp;
            if(i == count2)
                num2 = temp;

            if(pos1 == nums1.length){
                temp = nums2[pos2];
                pos2++;
            } else if(pos2 ==nums2.length){
                temp = nums1[pos1];
                pos1++;
            } else if(nums1[pos1] <= nums2[pos2]){
                temp = nums1[pos1];
                pos1++;
            } else {
                temp = nums2[pos2];
                pos2++;
            }
            i++;
        }

        return (num1 + num2) / 2.0;
    }

    public static void main(String[] args) {
        System.out.println(new Leet4().findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }
}
