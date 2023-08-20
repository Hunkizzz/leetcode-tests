package com.leetcode.tests.binary_search;

class Solution {
    public int search(int[] nums, int target) {
        int low = 0; int high = nums.length - 1;
        while(low <= high){
            int middle = (low + high) / 2;
            if(nums[middle] == target){
                return middle;
            }
            else if(target < nums[middle]){
                high = middle - 1;
            }
            else if(target > nums[middle]){
                low = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        System.out.println(solution.search(nums, 9));
    }
}