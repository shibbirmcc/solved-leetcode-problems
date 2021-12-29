class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> squares = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int target = nums[i] * nums[i];
            int start = 0, end = i;
            while( start <= end && squares.size() > 0){
                int index = start + (end - start)/2;
                if(index < squares.size() && target > squares.get(index)){
                    start = index + 1;
                }else if(index < squares.size() && target < squares.get(index)){
                    end = index - 1;
                }else{
                    start = index;
                    break;
                }
            }
            if(start >= squares.size()){
                squares.add(target);
            }else{
                squares.add(start, target);    
            }
        }
        
        return squares.stream().mapToInt(i -> i).toArray();
    }
}