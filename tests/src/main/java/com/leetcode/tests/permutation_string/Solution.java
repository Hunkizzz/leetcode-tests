package com.leetcode.tests.permutation_string;

import java.util.Arrays;

class Solution {
    private boolean isContain = false;

    // Generating permutation using Heap Algorithm
    void heapPermutation(String test, char[] a, int size, int n) {
        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1) {
            if (String.valueOf(a).contains(test)) {
                isContain = true;
                return;
            }
        }

        for (int i = 0; i < size; i++) {
            heapPermutation(test, a, size - 1, n);

            // if size is odd, swap 0th i.e (first) and
            // (size-1)th i.e (last) element
            char temp;
            if (size % 2 == 1) {
                temp = a[0];
                a[0] = a[size - 1];
            }

            // If size is even, swap ith
            // and (size-1)th i.e last element
            else {
                temp = a[i];
                a[i] = a[size - 1];
            }
            a[size - 1] = temp;
        }
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i += 1) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if(checkZeros(count))
            return true;
        for(int i = s1.length(); i < s2.length(); i++){
            count[s2.charAt(i - s1.length()) - 'a']++;
            count[s2.charAt(i) - 'a']--;
            if(checkZeros(count))
                return true;
        }
        return false;
    }

    private boolean checkZeros(int[] count) {
        for(int num : count){
            if(num != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        Solution solution = new Solution();

        System.out.println(solution.checkInclusion(s1, s2));
    }
}

