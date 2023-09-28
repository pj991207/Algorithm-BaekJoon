import java.util.*;

class Solution {
    static int[] arr;
    static int answer;
    static int N;
    public int solution(int n) {
        N = n;
        arr = new int[N];
        nQueen(0);
        return answer;
    }
    static void nQueen(int depth){
        if(depth==N){
            answer++;
            return;
        }
        for(int i = 0; i<N;i++){
            arr[depth] = i;
            if(check(depth)){
                nQueen(depth+1);
            }
        }
    }
    static boolean check(int depth){
        int num = arr[depth];
        for(int i = 0; i<depth;i++){
            int comp = arr[i];
            if(comp==num){
                return false;
            }
            if(Math.abs(comp-num)==Math.abs(depth-i)){
                return false;
            }
        }
        return true;
    }
}