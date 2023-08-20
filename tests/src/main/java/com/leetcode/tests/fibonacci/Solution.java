package com.leetcode.tests.fibonacci;

class Solution {
    public int fib(int n) {
        if (n < 0)
            return -1;
        int sum = 0;
        int prev = 0;
        for (int i = 0; i <= n; i++) {
            if (i == 1) {
                sum = 1;
                continue;
            } else
                sum += prev;
            prev = sum - prev;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(10));
    }
}