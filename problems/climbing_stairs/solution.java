class Solution {
    private int[] counts = new int[50];
    
    public int climbStairs(int n){
        Arrays.fill(counts, -1);
        climb(n, 0);
        return counts[0];
    }
    
    
    private int climb(int n, int current){
        if(current > n){
            return 0 ;
        }
        if(current == n){
            return 1;
        }
        if(counts[current] != -1){
            return counts[current];
        }
        
        return counts[current] = climb(n, current + 1) + climb(n, current + 2);
    }
}