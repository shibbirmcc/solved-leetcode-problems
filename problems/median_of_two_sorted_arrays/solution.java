import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		PriorityQueue<Integer> maxSet = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> minSet = new PriorityQueue<Integer>();

		for (int n : nums1) {
			populateMinMaxSets(n, minSet, maxSet);
		}

		for (int n : nums2) {
			populateMinMaxSets(n, minSet, maxSet);
		}

		if (maxSet.size() == minSet.size()) {
			return (double) ((maxSet.peek() + minSet.peek()) / (float) 2);
		} else {
			return (double) maxSet.peek();
		}
	}

	private static void populateMinMaxSets(int n, PriorityQueue<Integer> minSet, PriorityQueue<Integer> maxSet) {
		if (maxSet.isEmpty()) {
			maxSet.add(n);
		} else if (maxSet.size() == minSet.size()) {
			if (n < minSet.peek()) {
				maxSet.add(n);
			} else {
				minSet.add(n);
				maxSet.add(minSet.remove());
			}
		} else if (maxSet.size() > minSet.size()) {
			if (n > maxSet.peek()) {
				minSet.add(n);
			} else {
				maxSet.add(n);
				minSet.add(maxSet.remove());
			}
		}
	}
}