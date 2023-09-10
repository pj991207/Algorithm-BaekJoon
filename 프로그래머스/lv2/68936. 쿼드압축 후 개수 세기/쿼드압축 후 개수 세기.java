import java.util.*;
import java.io.*;
class Solution {
    static int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        capsulation(0,0,arr[0].length,arr);
        return answer;
    }
    public static void capsulation(int y, int x,int len,int[][] arr){
        if(len==1){
            answer[arr[y][x]]++;
            return;
        }
        Set<Integer> set = new HashSet<>();
        set.add(arr[y][x]);
        for(int i = 0; i<len;i++){
            for(int j = 0;j<len;j++){
                if(!set.contains(arr[y+i][x+j])){
                    capsulation(y,x,len/2,arr);
                    capsulation(y+len/2,x,len/2,arr);
                    capsulation(y+len/2,x+len/2,len/2,arr);
                    capsulation(y,x+len/2,len/2,arr);
                    return;
                }
            }
        }
        answer[arr[y][x]]++;
    }
}