/*You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104

Source code:
*/

//using recursion

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        return search(matrix,target,0,rows*cols-1,cols);
    }
    public boolean search(int[][] matrix,int target,int left,int right,int cols){
        if(left>right) return false;

        int mid=(left+right)/2;
        int row=mid/cols;
        int col=mid%cols;

        if(matrix[row][col]==target){
            return true;
        }
        else if(matrix[row][col]<target){
            return search(matrix,target,mid+1,right,cols);
        }
        else{
            return search(matrix,target,left,mid-1,cols);
        }
    }
}