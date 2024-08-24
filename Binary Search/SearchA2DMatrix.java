// TC - O(log(mn)), SC - O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][matrix[0].length - 1]) {
                return binarySearch(matrix, i, target);
            }
        }

        return false;
    }

    private boolean binarySearch(int[][] matrix, int row, int target) {
        // left & right for columns
        int mid = 0, left = 0, right = matrix[0].length - 1;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}