class Solution {
    public void sortColors(int[] nums) {
        int redCount = 0, whiteCount = 0, blueCount = 0;
        for(int n: nums){
            if(n == 0 ) redCount++;
            else if(n == 1) whiteCount++;
            else if(n == 2) blueCount++;
        }
        int resultIndex = 0;
        int redIndexLimit = resultIndex + redCount;
        for(; resultIndex < redIndexLimit;  resultIndex++){
            nums[resultIndex] = 0;
        }
        
        int whiteIndexLimit = resultIndex + whiteCount;
        for(; resultIndex < whiteIndexLimit;  resultIndex++){
            nums[resultIndex] = 1;
        }
        
        int blueIndexLimit = resultIndex + blueCount;
        for(; resultIndex < blueIndexLimit;  resultIndex++){
            nums[resultIndex] = 2;
        }
    }
}