package com.leetcode.tests.rotate_binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FindMinimum
{
        public static int findMin(List<Integer> arr, int low,
                                  int high)

        {
            // If the array is not rotated
            if (arr.get(low) <= arr.get(high)) {
                return arr.get(low);
            }

            // Binary search
            while (low <= high) {
                int mid = (low + high) / 2;

                // Check if mid is the minimum element
                if (arr.get(mid) < arr.get(mid - 1)) {
                    return arr.get(mid);
                }
                // If the left half is sorted, the minimum
                // element must be in the right half
                if (arr.get(mid) > arr.get(high)) {
                    low = mid + 1;
                }

                // If the right half is sorted, the minimum
                // element must be in the left half
                else {
                    high = mid - 1;
                }
            }

            // If no minimum element is found, return -1
            return -1;
        }

        // Driver program to test above functions
        public static void main(String[] args)
        {
            List<Integer> arr = new ArrayList<>(
                    Arrays.asList(5, 6, 1, 2, 3, 4));
            int N = arr.size();
            System.out.println("The minimum element is "
                    + findMin(arr, 0, N - 1));
        }
    }
