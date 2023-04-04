class Solution {
    public static int[] memo = new int[1000000];
    public int solution(int n) {
        int answer = 0;
        answer = fibo(n)%1234567;
        return answer;
    }
    public int fibo(int n){
        if(n<2){
            return n;
        }
        else{
            if(memo[n]>0){
                return memo[n];
            }
            memo[n] = fibo(n-1)%1234567+fibo(n-2)%1234567; 
        }
        return memo[n];
    }
}