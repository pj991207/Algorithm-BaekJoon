import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = d.length;
        int cnt = 0;
        Arrays.sort(d);
        for(int i = 0; i<d.length;i++){
            budget = budget - d[i];
            if(budget < 0){
                answer = cnt;
                break;
            }
            if(budget == 0){
                answer = cnt+1;
                break;
            }
            cnt++;
        }
        return answer;
    }
}