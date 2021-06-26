class Solution {
    public String removeOccurrences(String s, String part) {
    	int windowLength = part.length();
    	StringBuffer buf = new StringBuffer(s);
    	int windowStart = -1;
    	while( ( windowStart = buf.indexOf(part)) >= 0) {
    		buf.delete(windowStart, windowStart + windowLength);
    	}
    	return buf.toString();
    }
}