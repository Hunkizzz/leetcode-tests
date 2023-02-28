package com.leetcode.tests.addtwonnumbers;


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


class SolutionTest {
    /* Function to reverse the linked list */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // creating an dummy list
        ListNode curr = dummy; // intialising an pointer
        int carry = 0; // intialising our carry with 0 intiall
        // while loop will run, until l1 OR l2 not reaches null OR if they both reaches null. But our carry has some value in it.
        // We will add that as well into our list
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0; // intialising our sum1
            if (l1 != null) { // adding l1 to our sum & moving l1
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) { // adding l2 to our sum & moving l2
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry; // if we have carry then add it into our sum
            carry = sum / 10; // if we get carry, then divide it by 10 to get the carry
            ListNode node = new ListNode(sum % 10); // the value we'll get by moduloing it, will become as new node so. add it to our list
            curr.next = node; // curr will point to that new node if we get
            curr = curr.next; // update the current every time
        }
        return dummy.next; // return dummy.next bcz, we don't want the value we have consider in it intially!!
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(6);
        listNode2.next = listNode3;
        listNode.next = listNode2;
        listNode5.next = listNode6;
        listNode4.next = listNode5;
        addTwoNumbers(listNode, listNode4);
    }
}