/*
Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

//SOURCE CODE:

class Solution {
    public int lengthOfLongestSubstring(String str) {
        int n = str.length();
        int maxi = 0;
        int i = 0; // left pointer
        Set<Character> set = new HashSet<>();

        for (int j = 0; j < n; j++) {
            char c = str.charAt(j);

            // shrink window until no duplicate
            while (set.contains(c)) {
                set.remove(str.charAt(i));
                i++;
            }

            set.add(c);
            maxi = Math.max(maxi, j - i + 1);
        }
        return maxi;
    }
}