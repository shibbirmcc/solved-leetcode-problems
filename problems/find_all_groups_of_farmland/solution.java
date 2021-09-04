import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Solution {
    public int[][] findFarmland(int[][] land) {
        List<Integer[]> result = new ArrayList<>();
        for(int i=0; i<land.length; i++) {
        	for(int j=0; j<land[i].length; j++) {
        		if(land[i][j] == 1) {
        			System.out.println("startingIndex: "+i+","+j);
        			int rightMostIndex = j;
        			while(rightMostIndex < land[i].length && land[i][rightMostIndex] == 1) {
        				rightMostIndex++;
        			}
        			rightMostIndex -= (rightMostIndex == j) ? 0 : 1;
        			
        			int downMostIndex = i;
        			while(downMostIndex < land.length && land[downMostIndex][j] == 1) {
        				downMostIndex++;
        			}
        			downMostIndex -= (downMostIndex == i) ? 0 : 1;
        			System.out.println("complete: : "+i+","+j+","+downMostIndex+","+rightMostIndex);
        			
        			result.add(new Integer[] {i, j, downMostIndex, rightMostIndex});
        			
        			
        			for(int ii=i; ii<=downMostIndex; ii++) {
        				for(int jj=j; jj<=rightMostIndex; jj++) {
        					land[ii][jj] = 0;
        				}
        			}
        			
        		}
        	}
        }
        int[][] resultArray = new int[result.size()][4];
        for(int i=0; i<result.size(); i++) {
        	Integer[] r = result.get(i);
        	resultArray[i][0] = r[0];
        	resultArray[i][1] = r[1];
        	resultArray[i][2] = r[2];
        	resultArray[i][3] = r[3];
        }
        
    	return resultArray;
    }
}