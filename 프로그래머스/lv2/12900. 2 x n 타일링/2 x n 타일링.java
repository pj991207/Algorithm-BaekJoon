class Solution {
    static int[] memo = new int[60000];
    public int solution(int n) {
        int answer = 0;
        memo[1] = 1;
        memo[2] = 2;
        for(int i = 3 ; i<n+1;i++){
            memo[i] = memo[i-1]%1000000007+memo[i-2]%1000000007;
        }
        answer = memo[n]%1000000007;
        return answer;
    }
}