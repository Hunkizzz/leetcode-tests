package com.leetcode.tests.rotate_binary_search;

class RotateBinarySearch {

    /* Searches an element key in a
       pivoted sorted array arrp[]
       of size n */
    static int pivotedBinarySearch(int arr[], int n,
                                   int key) {
        int pivot = findPivot(arr, 0, n - 1);

        // If we didn't find a pivot, then
        // array is not rotated at all
        if (pivot == -1)
            return binarySearch(arr, 0, n - 1, key);

        // If we found a pivot, then first
        // compare with pivot and then
        // search in two subarrays around pivot
        if (arr[pivot] == key)
            return pivot;
        if (arr[0] <= key)
            return binarySearch(arr, 0, pivot - 1, key);
        return binarySearch(arr, pivot + 1, n - 1, key);
    }

    /* Function to get pivot. For array
       3, 4, 5, 6, 1, 2 it returns
       3 (index of 6) */
    static int findPivot(int arr[], int low, int high) {
        // base cases

        /* low + (high - low)/2; */
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid < high && arr[mid] > arr[mid + 1])
                return mid;
            if (mid > low && arr[mid] < arr[mid - 1])
                return (mid - 1);
            if (arr[low] >= arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    /* Standard Binary Search function */
    static int binarySearch(int arr[], int low, int high,
                            int key) {
        while (low <= high) {
            int middle = (low + high) / 2;
            if (arr[middle] == key) {
                return middle;
            } else if (key < arr[middle]) {
                high = middle - 1;
            } else if (key > arr[middle]) {
                low = middle + 1;
            }
        }
        return -1;
    }

    // main function
    public static void main(String args[]) {
        // Let us search 3 in below array
        int arr1[] = {6, 7, 1, 2, 3, 4, 5};
        int n = arr1.length;
        int key = 1;
        System.out.println(findPivot(arr1, 0, arr1.length - 1));
        System.out.println(
                "Index of the element is : "
                        + pivotedBinarySearch(arr1, n, key));
    }
}