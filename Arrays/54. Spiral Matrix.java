/*
Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/

//SOURCE CODE:


public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return ans;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // left -> right along top row
            for (int j = left; j <= right; j++) ans.add(matrix[top][j]);
            top++;

            // top -> bottom along right column
            for (int i = top; i <= bottom; i++) ans.add(matrix[i][right]);
            right--;

            // right -> left along bottom row (if still valid)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) ans.add(matrix[bottom][j]);
                bottom--;
            }

            // bottom -> top along left column (if still valid)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) ans.add(matrix[i][left]);
                left++;
            }
        }
        return ans;
    }
}
