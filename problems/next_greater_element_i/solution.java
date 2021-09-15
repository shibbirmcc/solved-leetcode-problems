class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        
        Stack<Integer> nextGreaterElements = new Stack<>();
        Map<Integer, Integer> greaterValues = new HashMap<>();
        for(int j= length2 - 1; j >= 0; j--){
            while(!nextGreaterElements.isEmpty() && nextGreaterElements.peek() < nums2[j]){
                nextGreaterElements.pop();
            }
            greaterValues.put(nums2[j], nextGreaterElements.isEmpty() ? -1 : nextGreaterElements.peek());
            nextGreaterElements.push(nums2[j]);
        }
        
        int[] result = new int[length1];
        for(int i=0; i<length1; i++){
            result[i] = greaterValues.getOrDefault(nums1[i], -1);
        }
        
        return result;
    }
}