/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start < end){
            int index = start + (end - start)/2;
            if(isBadVersion(index)){
                end = index; 
            }else{
                start = index + 1;
            }
        }
        
        return end;
    }
}