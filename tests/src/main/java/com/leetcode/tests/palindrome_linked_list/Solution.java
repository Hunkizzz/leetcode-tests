package com.leetcode.tests.palindrome_linked_list;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> integerList = new ArrayList<>();
        while(head!= null){
            integerList.add(head.val);
            head = head.next;
        }
        int low = 0;
        int high = integerList.size() - 1;
        while (low < high){
            if(!Objects.equals(integerList.get(low), integerList.get(high)))
                return false;
            low++;
            high--;
        }
        return true;
    }
}