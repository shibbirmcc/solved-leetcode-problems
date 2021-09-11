class Solution {
	
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i]; // left bottom
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];  // left bottom = right bottom
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i]; // right bottom = right top
                matrix[j][n - 1 - i] = matrix[i][j]; // // right top = current
                matrix[i][j] = temp; // current = tmp
            }
        }
    }
}