package com.leetcode.tests.mergesortedarray;

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = nums1.clone();
        int i = 0, j = 0, k = 0;
        while (i < m - n && j < n) {
            if (temp[i] <= nums2[j]) {
                nums1[k] = temp[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < m) {
            if (temp[i] == 0) {
                break;
            }
            nums1[k++] = nums1[i++];
        }
        while (j < n && k < m) {
            if (nums2[j] == 0)
                continue;
            nums1[k] = nums2[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0, 0, 0, 0, 0};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 12};
//        int[] nums1 = {0};
//        int[] nums2 = {1,0,0};
        Solution solution = new Solution();
        solution.merge(nums1, nums1.length, nums2, nums2.length);

        System.out.println(Arrays.toString(nums1));

    }
}