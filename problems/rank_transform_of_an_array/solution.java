import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
    	int[] rank = new int[arr.length];
        Set<Integer> data = new TreeSet<>();
        Map<Integer, Set<Integer>> dataIndex = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
        	data.add(arr[i]);
        	dataIndex.computeIfAbsent(arr[i], f->new HashSet<>()).add(i);
        }
        
        final AtomicInteger calculatedRank = new AtomicInteger(0);
        for(Integer value : data) {
        	dataIndex.get(value).forEach(index -> rank[index] = calculatedRank.get() + 1);
        	calculatedRank.set(calculatedRank.get() + 1);
        }
        return rank;
    }
}