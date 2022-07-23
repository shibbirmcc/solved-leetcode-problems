class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int setCount = 1;
        Set<Integer> data = new HashSet<>();
        
        for(int i=0; i<rolls.length; i++){
            data.add(rolls[i]);
            if(data.size() == k){
                setCount++;
                data.clear();
            }
        }
        
        return setCount;
    }
}