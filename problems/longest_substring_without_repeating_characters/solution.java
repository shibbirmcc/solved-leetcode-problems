class Solution {
    public int lengthOfLongestSubstring(String s) {
    	Map<Character, Integer> lastIndex = new HashMap<>();

        int count = 0;
        int startIndex = 0;
        
        for(int i=0; i<s.length(); i++){
        	char c = s.charAt(i);
        	Integer lastIndexOfC = lastIndex.get(c);
        	lastIndex.put(c, i);
        	if(lastIndexOfC != null && lastIndexOfC >= startIndex) {
        		startIndex = lastIndexOfC + 1;
        	}
            count = Math.max(count, i - startIndex + 1);
        }
        
        return count;
    }
}