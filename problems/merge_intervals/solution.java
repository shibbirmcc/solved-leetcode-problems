class Solution {
    public int[][] merge(int[][] intervals) {
		Map<Integer, Integer> startEndMap = new TreeMap<>();
		for (int[] data : intervals) {
			int endBoundary = startEndMap.getOrDefault(data[0], data[1]);
			if (endBoundary <= data[1]) {
				startEndMap.put(data[0], data[1]);
			}
		}

		Set<Integer> keySet = startEndMap.keySet();
		int[][] mergedIntervals = new int[keySet.size()][2];
		int mergedIndex = -1;
		for (int start : keySet) {
			int end = startEndMap.get(start);
            
			if (mergedIndex == -1) {
                ++mergedIndex;
				mergedIntervals[mergedIndex][0] = start;
				mergedIntervals[mergedIndex][1] = end;
                // System.out.println("Adding first entry :: "+mergedIntervals[mergedIndex][0]+", "+mergedIntervals[mergedIndex][1]);
			} else if (mergedIntervals[mergedIndex][1] >= start && mergedIntervals[mergedIndex][1] <= end) {
				mergedIntervals[mergedIndex][1] = end;
                // System.out.println("Updating existing entry :: "+mergedIntervals[mergedIndex][0]+", "+mergedIntervals[mergedIndex][1]);
			}else if(mergedIntervals[mergedIndex][1] < start && mergedIntervals[mergedIndex][1] < end) {
				++mergedIndex;
				mergedIntervals[mergedIndex][0] = start;
				mergedIntervals[mergedIndex][1] = end;
                // System.out.println("Adding new entry :: "+mergedIntervals[mergedIndex][0]+", "+mergedIntervals[mergedIndex][1]);
			}
            
            // System.out.println("start: "+start+", end: "+end+", mergedIndex: "+mergedIndex+" :: "+mergedIntervals[mergedIndex][0]+", "+mergedIntervals[mergedIndex][1]);
		}
		
		int[][] finalIntervals = new int[mergedIndex+1][2];
		for(int i=0; i<=mergedIndex; i++) {
			finalIntervals[i][0] = mergedIntervals[i][0];
			finalIntervals[i][1] = mergedIntervals[i][1];
		}

		return finalIntervals;
    }
}