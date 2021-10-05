class Solution {
    int[] fib = new int[40];
    public int tribonacci(int n) {
        fib[0] = 0;
        fib[1] = 1;
        fib[2] = 1;
        if(n <= 0){
            return 0;
        }
        if(n > 2 && fib[n] == 0){
            for(int i=3; i<=n; i++){
                fib[i] = fib[i-1] + fib[i - 2] + fib[ i -3 ];
            }
        }
       return fib[n]; 
    }
}