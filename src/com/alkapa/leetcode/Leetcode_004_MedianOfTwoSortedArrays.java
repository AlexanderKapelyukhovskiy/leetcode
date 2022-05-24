package com.alkapa.leetcode;

public class Leetcode_004_MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int newSize = nums1.length + nums2.length;

        double c = Math.ceil(newSize / 2.0);
        int firstIndex = (int) c;
        int current = 0;

        for (int i = 0, j = 0; i + j < newSize; ) {
            if (i + j == firstIndex) {
                int med1 = current;

                if (newSize % 2 == 0) {
                    if (i == nums1.length) {
                        current = nums2[j];
                    } else if ( j == nums2.length) {
                        current = nums1[i];
                    } else if (nums1[i] < nums2[j]) {
                        current = nums1[i];
                    } else {
                        current = nums2[j];
                    }
                    return (med1 + current) / 2.0;
                } else {
                    return med1;
                }
            }
            if (i == nums1.length) {
                current = nums2[j++];
            } else if ( j == nums2.length) {
                current = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                current = nums1[i++];
            } else {
                current = nums2[j++];
            }
        }
        return current;
    }

    public static void main(String[] args) {
        //double med = findMedianSortedArrays(new int[] {1,2}, new int[]{3, 4});
        double med = findMedianSortedArrays(new int[] {}, new int[]{1});
        System.out.println(med);
    }
}
