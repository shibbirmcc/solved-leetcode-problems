class Solution {
    public int maximumRows(int[][] mat, int cols) {
        int rows = mat.length;
        int columns = mat[0].length;
        int maxRowsCovered = 0;

        List<Integer>[] colIndicesOf1 = new ArrayList[rows];

        for (int r = 0; r < rows; r++) {
            colIndicesOf1[r] = new ArrayList<>();
            for(int c = 0; c < columns; c++){
                if(mat[r][c] == 1){
                    colIndicesOf1[r].add(c);
                }
            }
        }
        
        List<int[]> columnCombinations = generateCombinations(columns, cols);
//        columnCombinations.forEach(array -> System.out.println(Arrays.toString(array)));

        for (int i = 0; i < columnCombinations.size(); i++) {
            int[] colArray = columnCombinations.get(i);
            Set<Integer> set = new HashSet<>();
            for(int j =0; j<colArray.length; j++){
                set.add(colArray[j]);
            }

            int countRowCoveredByTheCombination = 0;
            for (int r = 0; r < rows; r++) {
                if(colIndicesOf1[r].isEmpty()){
                    countRowCoveredByTheCombination++;
                }else{
                    Set<Integer> filteredSet =  colIndicesOf1[r].stream().filter(index -> !set.contains(index)).collect(Collectors.toSet());
                    if(filteredSet.isEmpty()){
                        countRowCoveredByTheCombination++;
                    }
                }
            }
            maxRowsCovered = Math.max(maxRowsCovered, countRowCoveredByTheCombination);
        }
        return maxRowsCovered;
    }

    public List<int[]> generateCombinations(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        combinationHelper(combinations, new int[r], 0, n - 1, 0);
        return combinations;
    }

    private void combinationHelper(List<int[]> combinations, int data[], int start, int end, int index) {
        if (index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = start;
            combinationHelper(combinations, data, start + 1, end, index + 1);
            combinationHelper(combinations, data, start + 1, end, index);
        }
    }
}