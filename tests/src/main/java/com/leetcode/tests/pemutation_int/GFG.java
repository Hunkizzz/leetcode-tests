package com.leetcode.tests.pemutation_int;
// Java program to count the number
// of required permutations

public class GFG {

    // Function to return the number of ways
    // to choose r objects out of n objects
    static int nCr(int n, int r) {
        int ans = 1;
        if (r > n - r)
            r = n - r;
        for (int i = 0; i < r; i++) {
            ans *= (n - i);
            ans /= (i + 1);
        }
        return ans;
    }

    // Function to return the number
    // of derangements of n
    static int countDerangements(int n) {
        int der[] = new int[n + 3];

        der[0] = 1;
        der[1] = 0;
        der[2] = 1;

        for (int i = 3; i <= n; i++)
            der[i] = (i - 1) * (der[i - 1]
                    + der[i - 2]);
        return der[n];
    }

    // Function to return the required
    // number of permutations
    static int countPermutations(int n, int k) {
        int ans = 0;
        for (int i = n - k; i <= n; i++) {

            // Ways to choose i indices from n indices
            int ways = nCr(n, i);

            // Derangements of (n - i) indices
            //System.out.println(ans) ;
            ans += (ways * countDerangements(n - i));
        }
        return ans;
    }

    // Driver Code to test above functions
    public static void main(String[] args) {
        int n = 16, k = 4;
        System.out.println(countPermutations(n, k));
//        System.out.println(factorial(4));
    }
    // This code is contributed by Ryuga
}