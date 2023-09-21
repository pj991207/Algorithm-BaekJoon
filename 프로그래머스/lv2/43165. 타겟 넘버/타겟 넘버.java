import java.util.*;
import java.io.*;
class Solution {
    static int answer;
    static int T;
    static int[] numbers;
    public int solution(int[] n, int target) {
        numbers = Arrays.copyOf(n,n.length);
        T = target;
        dfs(0,0);
        return answer;
    }
    static void dfs(int num,int start){
        if(start==numbers.length){
            if(num==T){
                answer++;
            }
            return;
        }
        for(int i = start; i<numbers.length;i++){
            dfs(num+numbers[i],i+1);
            dfs(num+numbers[i]*-1,i+1);
            return;
        }
    }
}