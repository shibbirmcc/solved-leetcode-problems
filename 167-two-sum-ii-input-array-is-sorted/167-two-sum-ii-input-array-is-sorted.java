class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i=0; i<numbers.length; i++){
            int complement = target - numbers[i];
            int nextIndex = getNextIndex(numbers, complement, i+1);
            if(nextIndex > i){
                return new int[]{i+1, nextIndex+1};
            }
        }
        return new int[]{};
    }
    
    
    private int getNextIndex(int[] numbers, int complement, int startIndex){
        int start = startIndex, end = numbers.length - 1;
        
        while(start >= startIndex && start <= end){
            int mid = ((end - start)/2) + start;
            
            if(numbers[mid] > complement){
                end = mid - 1;
            }else if(numbers[mid] < complement){
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    
}