import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        int[] menu = new int[tangerine[tangerine.length-1]+1];
        for(int j = 0; j<tangerine.length;j++){
            menu[tangerine[j]]+=1;
        }
        Arrays.sort(menu);
        Stack<Integer> stack = new Stack<>();
        for(int i : menu){
            stack.push(i);
        }
        int sum = 0;
        while(!stack.empty()){
            int num = stack.pop();
            sum+= num;
            answer++;
            if(sum>=k){
                break;
            }
        }
        return answer;
    }
}