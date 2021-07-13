class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        for(int n : nums) {
        	if(n != 0) {
        		product *= n;
        	}else {
        		zeroCount++;
        	}
        }

        for(int i=0; i<nums.length; i++) {
        	if(nums[i] == 0) {
        		if(zeroCount > 1) {
        			nums[i] = 0;
        		}else {
        			nums[i] = product;
        		}
        	}else {
        		
        		if(zeroCount > 0) {
        			nums[i] = 0;
        		}else {
        			nums[i] = product/nums[i];
        		}
        	}
        }
        return nums;
    }
}