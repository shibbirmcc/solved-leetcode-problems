class Solution {
    public int findPeakElement(int[] nums) {
    	if(nums.length == 1) {
    		return 0;
    	}else if(nums.length == 2) {
    		return nums[0] > nums[1] ? 0 : 1;
    	}

    	int start = 0;
    	int end = nums.length - 1;
		while (start <= end && start < nums.length && end >= 0) {
			if(start == 0) {
				if(nums[start] > nums[start + 1]) {
					return start;
				}else {
					start++;
				}
			}else if(start == nums.length - 1) {
				if(nums[start] > nums[start - 1]) {
					return start;
				}else {
					start++;
				}
			}else if (nums[start] > nums[start - 1] && nums[start] > nums[start + 1]) {
				return start;
			} else {
				start++;
			}

			if(end == nums.length - 1) {
				if(nums[end] > nums[end - 1]) {
					return end;
				}else {
					end--;
				}
			} else if(end == 0) {
				if(nums[end] > nums[end + 1]) {
					return end;
				}else {
					end--;
				}
			}
			else if (nums[end] > nums[end - 1] && nums[end] > nums[end + 1]) {
				return end;
			} else {
				end--;
			}
		}
    	return 0;
    }
}