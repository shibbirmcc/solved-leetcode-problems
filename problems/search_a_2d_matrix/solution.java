class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix[0].length == 0) {
    		return false;
    	}
    	
    	int row = findRow(matrix, target, 0, matrix.length - 1, matrix[0].length - 1);
    	if(row == -1) {
    		return false;
    	}
    	
        System.out.println("row: "+row);
        
    	if(matrix[row].length == 0) {
    		return false;
    	}else if(matrix[row].length == 1) {
    		return matrix[row][0] == target;
    	}
    	
    	return findColumn(matrix, target, row, matrix[row].length - 1) != -1;
    }
    
	private int findRow(int[][] matrix, int target, int startRow, int endRow, int endColumn) {
		if(matrix[startRow][endColumn] >= target) {
			return startRow;
		}
		while(startRow <= endRow) {
			int pivot = (startRow + endRow) / 2;
			if(matrix[pivot][0] <= target && matrix[pivot][endColumn] >= target) {
				return pivot;
			}else if(matrix[pivot][endColumn] < target) {
				startRow = pivot + 1;
			}else if(matrix[pivot][0] > target) {
				endRow = pivot - 1;
			}
		}
		return -1;
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