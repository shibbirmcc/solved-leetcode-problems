class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> elements = new Stack<>();
        for(int i=nums.length - 1; i>=0; i--){
            elements.push(nums[i]);
        }
        
        for(int i=nums.length - 1; i>=0; i--){
            while(!elements.isEmpty() && elements.peek() <= nums[i]){
                elements.pop();
            }
            result[i] = elements.isEmpty() ? -1 : elements.peek() ;
            elements.push(nums[i]);
        }
        
        return result;
    }
}