class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean result = false;
        int rotationCount = 0;
        
        while(!result && rotationCount < 4){
            for (int i = 0; i < (n + 1) / 2; i ++) {
                for (int j = 0; j < n / 2; j++) {
                    int temp = mat[n - 1 - j][i]; // left bottom
                    mat[n - 1 - j][i] = mat[n - 1 - i][n - j - 1];  // left bottom = right bottom
                    mat[n - 1 - i][n - j - 1] = mat[j][n - 1 -i]; // right bottom = right top
                    mat[j][n - 1 - i] = mat[i][j]; // // right top = current
                    mat[i][j] = temp; // current = tmp
                }
            }

            boolean match = true;
            
            for(int i=0; i<n && match; i++){
                for(int j=0; j<n && match; j++){
                    match = mat[i][j] == target[i][j];
                }
            }
            
            result = match;
            rotationCount++;
        }
        

        
        return result;
    }
}