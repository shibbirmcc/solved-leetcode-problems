class Solution {
    public int countTriples(int n) {
    	boolean[] squareIndices = new boolean[(n*n)+1];
        int[] squares = new int[n+1];
        for(int i=1; i<=n; i++) {
        	squares[i] = i * i;
        	squareIndices[squares[i]] = true;
        }
        
        int countTriplet = 0;
        
        
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=n; j++) {
        		int squareSum = squares[i] + squares[j];
        		
        		if(squareSum < (squares[n] + 1) && squareIndices[squareSum]) {
        			countTriplet++;
        		}
        		
        		if(squareSum > squares[n]) {
        			break;
        		}
        	}
        }
        return countTriplet;
    }
}