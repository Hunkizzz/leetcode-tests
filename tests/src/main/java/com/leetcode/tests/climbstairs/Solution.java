package com.leetcode.tests.climbstairs;

class Solution {

    // 4 = 2 + 2; 1 + 1 + 1 + 1; 2 + 1 + 1; 1 + 2 + 1; 1 + 1 + 2
    //5 = 2 + 2 + 1; 1 + 1 + 1 + 1 + 1; 2 + 1 + 2; 1 + 2 + 2; 1 + 1 + 1 + 2;
    // 4 - 3

    // m = число перестановок
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int x = 1, y = 2;
        for (int i = 2; i < n; i++) {
            int temp = x;
            x = y;
            y = temp + y;
        }
        return y;
    }

    private int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }


    public static void main(String[] args) {
        int n = 45;
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(n));
    }
}