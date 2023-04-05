class Solution {
    static long[]memo = new long[2001];
    public long solution(int n) {
        long answer = 0;
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        answer = jump(n);
        return answer;
    }
    public static long jump(int n){
        if(n>2){
            if(memo[n]>0){
                return memo[n];
            }
            memo[n]=jump(n-1)+jump(n-2);
            memo[n] = memo[n]%1234567;
        }
        return memo[n];
    }
}