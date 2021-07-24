class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] occurances = new int[26];
        
        for(char c : s.toCharArray()) {
        	occurances[c-'a']++;
        }
        
        int count = -1;
        
        for(int i=0; i<26; i++) {
        	if(occurances[i] != 0) {
        		if(count == -1) {
        			count = occurances[i];
        		}else if(occurances[i] != count) {
        			return false;
        		}
        	}
        }
        return true;
    }
}