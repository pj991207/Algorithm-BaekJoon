import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {-1,-1};
        int start = 0;
        int end = 0;
        long sum = 0;
        int N = sequence.length;
        while(true){
            if(sum>=k){
                sum -= sequence[start++];
            }
            else if(end==N){
                break;
            }
            else{
                sum += sequence[end++];
            }
            if(sum==k){
                if(answer[0]==-1&&answer[1]==-1){
                    answer[0] = start;
                    answer[1] = end-1;
                    continue;
                }
                if(Math.abs(answer[1]-answer[0])>Math.abs(start-end+1)){
                    answer[0] = start;
                    answer[1] = end-1;
                    continue;
                }  
            }
        }
        return answer;
    }
}