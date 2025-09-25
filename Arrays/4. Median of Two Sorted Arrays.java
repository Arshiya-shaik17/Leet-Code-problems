/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
*/
//SOURCE CODE:

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];

        // Step 1: merge two arrays
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // copy remaining elements
        while (i < m) merged[k++] = nums1[i++];
        while (j < n) merged[k++] = nums2[j++];

        // Step 2: length of merged array
        int len = m + n;

        // Step 3 & 4: check odd or even
        if (len % 2 == 1) {
            // odd length → middle element
            return merged[len / 2];
        } else {
            // even length → average of two middle elements
            int mid1 = merged[len / 2 - 1];
            int mid2 = merged[len / 2];
            return (mid1 + mid2) / 2.0;
        }
    }
}
