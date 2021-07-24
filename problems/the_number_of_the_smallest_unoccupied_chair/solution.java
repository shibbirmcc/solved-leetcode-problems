import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrivalTime = times[targetFriend][0];
//        System.out.println("Target Arrival Time: "+targetArrivalTime);
    	
    	Arrays.sort(times, new Comparator<int[]>() {
    		public int compare(int[] a, int[] b) {
    			return Integer.compare(a[0], b[0]);
    		}
		});
    	
    	int n = times.length;
    	TreeSet<Integer> freeChairs = new TreeSet<>();
    	int lastChairIndex = 0;
    	freeChairs.add(lastChairIndex);

    	TreeSet<Integer> leavingTimes = new TreeSet<>();
        Map<Integer, Set<Integer>> leavingTimeChairMap = new TreeMap<>(); // leaving time, chair numbers

        freeChairs.remove(lastChairIndex);
        leavingTimes.add(times[0][1]);
        leavingTimeChairMap.computeIfAbsent(times[0][1], f->new HashSet<>()).add(lastChairIndex++);
        
        
        
        int selectedChair = 0;
        for(int i=1; i<n; i++) {
        	int arrivedAt = times[i][0];
        	
        	if(!leavingTimes.isEmpty()) {
            	int nextLeavingTime = leavingTimes.first();
            	while(!leavingTimes.isEmpty() && nextLeavingTime <= arrivedAt) {
            		leavingTimes.remove(nextLeavingTime);
            		for(int chair : leavingTimeChairMap.get(nextLeavingTime)) {
            			freeChairs.add(chair);
            		}
            		leavingTimeChairMap.remove(nextLeavingTime);
            		
            		if(!leavingTimes.isEmpty()) {
            			nextLeavingTime = leavingTimes.first();
            		}
            	}
        	}
        	if(freeChairs.isEmpty()) {
        		freeChairs.add(lastChairIndex++);
        	}
        	int chair = freeChairs.first();
        	freeChairs.remove(chair);
        	leavingTimes.add(times[i][1]);
        	leavingTimeChairMap.computeIfAbsent(times[i][1], f->new HashSet<>()).add(chair);
//        	System.out.println(i+"th friend takes chair: "+chair);
        	
        	if(arrivedAt == targetArrivalTime) {
        		selectedChair = chair;
        		break;
        	}
        }
    	return selectedChair;
    }
}