import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        while(n!=0){
            int plus = n%10;
            answer += plus;
            n = n/10;
        }
        return answer;
    }
}