package com.leetcode.tests.duplicates;

import java.util.Comparator;
import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {

//        HashSet<Integer> set = Arrays.stream(nums)        // IntStream
//                .boxed().collect(Collectors.toCollection(HashSet::new));
//        return nums.length != set.size();
//    }

        HashSet<Integer> hashSet = new HashSet<>();
//        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            hashSet.add(num);
            ++i;
            if (i > hashSet.size())
                return true;
        }
        return false;
    }
}

class IntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return a.compareTo(b);
    }
}