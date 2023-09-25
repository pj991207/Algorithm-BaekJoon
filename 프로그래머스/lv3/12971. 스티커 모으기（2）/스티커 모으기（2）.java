import java.util.*;
import java.io.*;
class Solution {
    static int[] dp1;
    static int[] dp2;
    static int answer;
    public int solution(int sticker[]) {
        if(sticker.length==1) return sticker[0];
        dp1 = new int[sticker.length];
        dp2 = new int[sticker.length];
        //첫번째를 뜯은 경우
        dp1[0] = sticker[0];
        dp1[1] = dp1[0];
        for(int i = 2; i<sticker.length-1;i++){
            dp1[i] = Math.max(dp1[i-2]+sticker[i],dp1[i-1]);
        }
        //첫번째를 안 뜯은 경우
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i = 2; i<sticker.length;i++){
            dp2[i] = Math.max(dp2[i-2]+sticker[i],dp2[i-1]);
        }
        return Math.max(dp1[sticker.length-2],dp2[sticker.length-1]);
    }
}