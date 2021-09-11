class Solution {
    public int[][] generateMatrix(int n) {
    	int[][] matrix = new int[n][n];
        int totalElements = n*n;
    	int processedElements = 0;
    	int layer = 0;
    	
    	while(processedElements < totalElements) {
    		int r = layer; int rEnd = n - layer;
    		int c = layer; int cEnd = n - layer;
    		
            // right
    		for(int j = c; j < cEnd; j++) {
    			matrix[r][j] = ++processedElements;
    		}
    		
            // down
    		for(int i = r + 1; i < rEnd; i++) {
    			matrix[i][cEnd-1] = ++processedElements;
    		}
    		
            // left
    		for(int j = cEnd - 2; j >= c; j--) {
    			matrix[rEnd-1][j] = ++processedElements;
    		}
            
            // up
    		for(int i = rEnd - 2; i > r; i--) {
    			matrix[i][c] = ++processedElements;
    		}
    		layer++;
    	}

    	return matrix;
    }
}