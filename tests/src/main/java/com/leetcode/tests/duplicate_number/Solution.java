package com.leetcode.tests.duplicate_number;

import java.util.HashSet;

class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int temp = 0;
        int counter = 0;
        int last = nums.length - 1;
        while (temp <= last) {
            hashSet.add(nums[temp]);
            counter++;
            if (hashSet.size() < counter) {
                return nums[temp];
            }
            temp++;
            hashSet.add(nums[last]);
            counter++;
            if (hashSet.size() < counter) {
                return nums[last];
            }
            last--;
        }
        return 0;
    }

    public int findDuplicate2(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (int) (low + (high - low) * 0.5);
            int cnt = 0;
            for (int a : nums) {
                if (a <= mid) ++cnt;
            }
            if (cnt <= mid) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    public static void main(String... args) {
        int[] array = {3,1,3,4,2};
        Solution solution = new Solution();
        System.out.println(solution.findDuplicate(array));
    }
}