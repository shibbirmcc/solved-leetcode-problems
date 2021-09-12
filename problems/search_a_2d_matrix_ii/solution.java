class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix[0].length == 0) {
    		return false;
    	}
    	for(int row = 0;row < matrix.length; row++){
            if(matrix[row].length == 0) {
                continue;
            }else if(matrix[row].length == 1) {
                if(matrix[row][0] == target){
                    return true;
                }
            }else if(matrix[row][0] == target){
                return true;
            }else if(matrix[row][0] < target){
                if(findColumn(matrix, target, row, matrix[row].length - 1) >= 0){
                    return true;
                }
            }
        }
    	return false;
    }
	
	private int findColumn(int[][] matrix, int target, int row, int endColumn) {
		int start = 0;
		int end = endColumn;

		while (start <= end) {
			int pivot = (start + end) / 2;
			if (matrix[row][pivot] == target) {
				return pivot;
			} else if (matrix[row][pivot] > target) {
				end = pivot - 1;
			} else {
				start = pivot + 1;
			}
		}
		return -1;
	}
}