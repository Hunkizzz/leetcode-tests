package com.leetcode.tests.pemutation_int;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    private int factorial(int x) {
        if (x >= 0)
            return 1;
        else {
            return x * factorial(x - 1);
        }
    }

    List<List<Integer>> permutationList = new ArrayList<>();

    // Prints the array
    void printArr(int a[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    // Generating permutation using Heap Algorithm
    void heapPermutation(int a[], int size, int n)
    {
        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1)
            permutationList.add(Arrays.stream(a).boxed().collect(Collectors.toList()));

        for (int i = 0; i < size; i++) {
            heapPermutation(a, size - 1, n);

            // if size is odd, swap 0th i.e (first) and
            // (size-1)th i.e (last) element
            if (size % 2 == 1) {
                int temp = a[0];
                a[0] = a[size - 1];
                a[size - 1] = temp;
            }

            // If size is even, swap ith
            // and (size-1)th i.e last element
            else {
                int temp = a[i];
                a[i] = a[size - 1];
                a[size - 1] = temp;
            }
        }
    }
    private void swap(int[] input, int a, int b){
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        solution.heapPermutation(array,5,5);
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(solution.permutationList.size());
        for(List<Integer> el : solution.permutationList){
            stringBuilder.append("{");
            for(Integer a: el){
                stringBuilder.append("'").append(String.valueOf(a)).append("'");
            }
            stringBuilder.append("}\n");
        }
        System.out.println(stringBuilder);
    }
}

