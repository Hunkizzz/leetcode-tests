package com.leetcode.tests.validparenheses;

import java.util.Stack;

class Solution {
    private final static String OPEN_VALID = "{[(";
    private final static String VALID = "{[()]}";
    private final static String CLOSED_VALID = "}])";

    public boolean isValid(String s) {
        Stack<Character> parenthesesStack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char el : charArray) {
            if (OPEN_VALID.contains(String.valueOf(el))) {
                parenthesesStack.add(el);
                continue;
            }
            if (!parenthesesStack.isEmpty() && CLOSED_VALID.contains(String.valueOf(el))) {
                char init = parenthesesStack.pop();
                if (init == '(' && el == ')')
                    continue;
                else if (init == '{' && el == '}')
                    continue;
                else if (init == '[' && el == ']')
                    continue;
                return false;
            } else return false;
        }
        return parenthesesStack.isEmpty();
    }


    public static void main(String[] args) {
        String s = "[({})]";
        String s2 = "()[]{}";
        Solution solution = new Solution();
        System.out.println(solution.isValid(s2));
    }
}