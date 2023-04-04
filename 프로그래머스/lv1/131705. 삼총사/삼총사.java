import java.util.*;
class Solution {
    static int[] ans = new int[13];
    static Stack<String> stack = new Stack<>();
    public int solution(int[] number) {
        int answer = 0;
        combi(0,1,number.length,3);
        while(!stack.empty()){
            String[] s = stack.pop().split(" ");
            if(number[Integer.parseInt(s[0])]+number[Integer.parseInt(s[1])]+number[Integer.parseInt(s[2])]==0){
                answer++;
            }
        }
        return answer;
    }
    public static void combi(int index,int value,int n,int m){
        if(index == m){
            StringBuilder sb = new StringBuilder();
            for(int i : ans){
                if(i==0){
                    break;
                }
                sb.append(i-1).append(" ");
            }
            stack.push(sb.toString());
            return;
        }
        if(value>n) return;
        ans[index] = value;
        combi(index+1,value+1,n,m);
        ans[index] = 0;
        combi(index,value+1,n,m);
    }
}