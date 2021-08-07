class Solution {
    public String makeFancyString(String s) {
        if(s.length() < 3) {
        	return s;
        }
        int startIndex = 0;
        StringBuffer buffer = new StringBuffer();
        
        for(startIndex = 0; startIndex < s.length() - 2; startIndex++) {
        	if(!(s.charAt(startIndex) == s.charAt(startIndex + 1) && s.charAt( startIndex + 1) == s.charAt( startIndex + 2 ))) {
        		buffer.append(s.charAt(startIndex));
        	}	
        }
        
        while(startIndex < s.length()) {
        	buffer.append(s.charAt(startIndex++));
        }        
        return buffer.toString();
    }
}