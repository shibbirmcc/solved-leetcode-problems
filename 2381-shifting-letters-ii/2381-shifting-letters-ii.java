class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] chars = s.toCharArray();
        int[] prefixShift = new int[chars.length + 1];
        
        for(int i= 0; i < shifts.length; i++){
            prefixShift[shifts[i][0]] += (shifts[i][2] == 1) ? 1 : -1;
            prefixShift[shifts[i][1] + 1] += (shifts[i][2] == 1) ? -1 : 1;
        }
        
        for(int i= 1; i < chars.length; i++){
            prefixShift[i] += prefixShift[i-1];
        }
        
        for(int i= 0; i < chars.length; i++){
            chars[i] = shift(chars[i], prefixShift[i]);
        }
        
        return new String(chars);
    }
    
    private char shift(char c, int count){
        if(count == 0 )
            return c;
        int normalizedCount = Math.abs(count) % 26;
        normalizedCount *= count > 0 ? 1 : -1;
        
        int normalizedChar = (int)(c - 'a')%26;
        int shiftedChar = (normalizedChar + (normalizedCount > 0 ? normalizedCount : 26 + normalizedCount) ) % 26;
        return (char)( shiftedChar + 97 );
        
    }
}