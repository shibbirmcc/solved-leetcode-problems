class Solution {
    public String kthDistinct(String[] arr, int k) {
        Set<String> distinct = new HashSet<>();
        Set<String> nonDistinct = new HashSet<>();
        
        for(String s : arr){
            if(!nonDistinct.contains(s)){
                if(!distinct.contains(s)){
                    distinct.add(s);
                }else{
                    distinct.remove(s);
                    nonDistinct.add(s);
                }
            }
        }

        int count = 0;
        for(String s : arr){
            if(distinct.contains(s)){
                if(count == (k-1)){
                    return s;
                }else{
                    count++;
                }
                
            }
        }
        
        
        
        return "";
    }
}