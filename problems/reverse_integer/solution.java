class Solution {
    public int reverse(int x) {
    	boolean isnegative = false;
    	
    	if(x < 0) {
    		isnegative = true;
    		x *= -1; 
    	}
    	
        long result = 0;
        int count = 0;
        while(x > 0) {
        	int digit = x % 10;
        	x = x / 10;
        	
        	if(result == 0) {
        		result = digit;
        	}else {
        		result = (result * 10 ) + digit;
        	}
        	count++;
        	if(count >= 10 && ( result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) ) {
        		return 0;
        	}
        }
        
		if (isnegative && result > 0) {
			result *= -1;
		}
        
        return (int) result;
    }
}