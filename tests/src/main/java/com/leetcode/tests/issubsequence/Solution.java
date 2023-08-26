package com.leetcode.tests.issubsequence;

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;
        if (t.length() < s.length())
            return false;
        char[] sCharArray = s.toCharArray();
        char[] targetArray = new char[s.length()];
        int nextSearch = 0;
        char[] charArray = t.toCharArray();
        for (char temp : charArray) {
            char searchSymbol = sCharArray[nextSearch];
            if (temp == searchSymbol) {
                targetArray[nextSearch] = temp;
                nextSearch++;
            }
            if(nextSearch > sCharArray.length - 1)
                break;
        }
        for(int i = 0; i < s.length(); i ++){
            if(sCharArray[i] != targetArray[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ab";
        String source = "baab";

        Solution solution = new Solution();

        System.out.println(solution.isSubsequence(s, source));
    }
}