package com.leetcode.tests.cyclinglinkedlist;


import java.util.HashSet;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> s = new HashSet<ListNode>();
        while (head != null) {
            // If we have already has this node
            // in hashmap it means their is a cycle
            // (Because you we encountering the
            // node second time).
            if (s.contains(head))
                return true;
 
            // If we are seeing the node for
            // the first time, insert it in hash
            s.add(head);
 
            head = head.next;
        }
 
        return false;
    }
}