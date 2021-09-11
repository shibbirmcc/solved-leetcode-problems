class Solution {
    
	int MAX = 34;
	List<List<Integer>> triangle = new ArrayList<>();
	
	public Solution() {
		triangle.add(Arrays.asList(1));
		triangle.add(Arrays.asList(1, 1));
		for(int i=2; i<MAX; i++) {
			List<Integer> previousList = triangle.get(i-1);
			List<Integer> newList = new ArrayList<>();
			newList.add(1);
			for(int j = 1; j<previousList.size(); j++) {
				newList.add(previousList.get(j-1) + previousList.get(j));
			}
			newList.add(1);
			triangle.add(newList);
		}
	}
	
    public List<Integer> getRow(int rowIndex) {
    	return triangle.get(rowIndex);
    }
}