class Solution {
    public int minTimeToType(String word) {
        int time = 0;
        char typeWriterChar = 'a';
        
        for(char c : word.toCharArray()) {

        	
        	if(c > typeWriterChar) {
        		int clockWiseTime = Math.abs((int)(c - typeWriterChar)) + 1 ;
        		int antiClockWiseTime = Math.abs((int)(typeWriterChar - 'a')) + Math.abs((int)('z' - c)) + 2;
            	time += Math.min(antiClockWiseTime, clockWiseTime);
            	typeWriterChar = c;
        		
        	}else if(c < typeWriterChar) {
        		int clockWiseTime = Math.abs((int)('z' - typeWriterChar)) + Math.abs((int)('a' - c)) + 2;
        		int antiClockWiseTime = Math.abs((int)(typeWriterChar - c)) + 1;
            	time += Math.min(antiClockWiseTime, clockWiseTime);
            	typeWriterChar = c;
        		
        	}else if( c == typeWriterChar){
        		int clockWiseTime = 1;
        		int antiClockWiseTime = 1;
            	time += Math.min(antiClockWiseTime, clockWiseTime);
            	typeWriterChar = c;
        	}
        }
        
        
        return time;
    }
}