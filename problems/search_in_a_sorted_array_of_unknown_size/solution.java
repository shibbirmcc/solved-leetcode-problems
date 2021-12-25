/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int start = 0;
        int end = 10000;
        while(end >= start){
            int index = (start + end)/2;
            int data = reader.get(index);
            if(target < data){
                end = index - 1;
            }else if(target > data){
                start = index + 1;
            }else{
                return index;
            }
        }
        
        
        return -1;
    }
}