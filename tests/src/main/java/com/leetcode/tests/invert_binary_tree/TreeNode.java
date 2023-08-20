package com.leetcode.tests.invert_binary_tree;


import java.util.ArrayDeque;
import java.util.Queue;

//Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invertTreeWithoutRecursion(TreeNode root) {

        if (root == null) {
            return;
        }

        // maintain a queue and push the root node
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        // loop till queue is empty
        while (!q.isEmpty()) {
            // dequeue front node
            TreeNode curr = q.poll();

            // swap the left child with the right child
            swap(curr);

            // enqueue left child of the popped node
            if (curr.left != null) {
                q.add(curr.left);
            }

            // enqueue right child of the popped node
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    public void swap(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
    }

    public void invert(TreeNode root) {
        if (root == null)
            return;

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invert(root.left);
        invert(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        Solution solution = new Solution();
        solution.invertTreeWithoutRecursion(treeNode);

    }
}