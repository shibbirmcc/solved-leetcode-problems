class Solution {
    public int findMin(int[] nums) {
		if(nums == null || nums.length == 0) {
			return -1;
		}
		if(nums.length == 1) {
			return nums[0];
		}
		int rotationIndex = findRotaionIndex(nums, 0, nums.length-1);
		return nums[rotationIndex];
    }
	
	public int findRotaionIndex(int[] nums, int left, int right) {
		if (nums[left] < nums[right])
			return 0;
		
		while (left <= right) {
			int pivot = (left + right) / 2;
			if (nums[pivot] > nums[pivot + 1]) {
				return pivot + 1;
			} else if (nums[pivot] < nums[left]) {
				right = pivot - 1;
			} else {
				left = pivot + 1;
			}
		}
		return 0;
	}
}