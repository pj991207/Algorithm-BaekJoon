import java.util.*;
import java.io.*;
class Solution {
    static int weight;
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        weight = 2*w+1;
        answer += func(1,stations[0]-w-1);
        for(int i = 0; i<stations.length-1; i++){
            answer += func(stations[i]+w+1,stations[i+1]-w-1);
        }
        answer += func(stations[stations.length-1]+w+1,n);
        return answer;
    }
    static int func(int start,int end){
        if(start>end){
            return 0;
        }
        if((end-start+1)%weight==0){
            return (end-start+1)/weight;
        }
        return (end-start+1)/weight+1;
    }
}