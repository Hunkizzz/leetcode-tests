package com.leetcode.tests.tribonacci;

class Solution {
    public int tribonacci(int n) {
        if (n < 0)
            return -1;
        if (n == 1 || n == 2)
            return 1;
        int sum = 2;
        int prev = 1;
        int prev2 = 1;
        for (int i = 3; i < n; i++) {
            sum = sum + prev + prev2;
            prev = sum - prev - prev2;
            prev2 = sum - prev - prev2;
        }
        return sum;
    }

    //0 1 1 2 4 7 13
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.tribonacci(25));
    }
}