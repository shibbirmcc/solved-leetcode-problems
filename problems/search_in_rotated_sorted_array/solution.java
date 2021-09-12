class Solution {
	public int search(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return -1;
		}
		if(nums.length == 1) {
			return nums[0] == target ? 0 : -1;
		}
		int rotationIndex = findRotaionIndex(nums, 0, nums.length-1);
		if(rotationIndex == 0 || target < nums[0]) {
			return search(nums, target, rotationIndex, nums.length-1);
		}
		return search(nums, target, 0, rotationIndex);
	}

	public int search(int[] nums, int target, int left, int right) {
		while (left <= right) {
			int pivot = (left + right) / 2;
			if (nums[pivot] == target) {
				return pivot;
			} else if (target < nums[pivot]) {
				right = pivot - 1;
			}
			else {
				left = pivot + 1;
			}
		}
		return -1;
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