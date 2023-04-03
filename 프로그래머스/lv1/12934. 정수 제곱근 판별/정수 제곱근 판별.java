class Solution {
    public long solution(long n) {
        long answer = 0;
        for(int i = 1; i<100000000;i++){
            if(n == (long)i*i){
                answer = (long)(i+1)*(i+1);
                break;
            }
        }
        if(answer == 0){
            answer = -1;
        }
        return answer;
    }
}