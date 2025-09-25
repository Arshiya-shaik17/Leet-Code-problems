/*
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 */

//SOURCE CODE:
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] memo = new Integer[n][n]; // to store already computed results
        return dfs(triangle, 0, 0, memo);
    }

    private int dfs(List<List<Integer>> triangle, int row, int col, Integer[][] memo) {
        // Base case: if at the last row, return its value
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        // If already computed, return it
        if (memo[row][col] != null) {
            return memo[row][col];
        }

        // Recurse to two possible paths
        int down = dfs(triangle, row + 1, col, memo);
        int downRight = dfs(triangle, row + 1, col + 1, memo);

        // Store result in memo
        memo[row][col] = triangle.get(row).get(col) + Math.min(down, downRight);
        return memo[row][col];
    }
}
