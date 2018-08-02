package com.lu;

public class Leet4 {
    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int index1 = 0, index2 = 0, number1 = 0, number2 = 0;
        if (totalLength % 2 == 0) {
            index2 = totalLength / 2 + 1;
            index1 = index2 - 1;
        } else {
            index2 = (totalLength + 1) / 2;
            index1 = -1;
        }

        for (int i = 0, j = 0, count = 0; ; count++) {
            if (i == nums1.length) {
                if (count + 1 == index1)
                    number1 = nums2[j];
                else if (count + 1 == index2) {
                    number2 = nums2[j];
                    break;
                }
                j++;
                continue;
            } else if (j == nums2.length) {
                if (count + 1 == index1)
                    number1 = nums1[i];
                else if (count + 1 == index2) {
                    number2 = nums1[i];
                    break;
                }
                i++;
                continue;
            }

            if (count + 1 == index1)
                number1 = Math.min(nums1[i], nums2[j]);
            else if (count + 1 == index2) {
                number2 = Math.min(nums1[i], nums2[j]);
                break;
            }

            if (nums1[i] <= nums2[j]) {
                i++;
                continue;
            } else {
                j++;
                continue;
            }

        }

        return index1 == -1 ? (double) number2 : (double) (number1 + number2) / 2;
    }

    public static void main(String[] args) {
        System.out.println(new Leet4().findMedianSortedArrays(new int[]{1}, new int[]{}));
    }
}
