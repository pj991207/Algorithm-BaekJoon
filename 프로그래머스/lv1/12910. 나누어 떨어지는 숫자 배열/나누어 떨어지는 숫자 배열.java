import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<arr.length;i++){
            if(arr[i]%divisor==0){
                stack.push(arr[i]);
            }
        }
        if(stack.size() == 0){
            int[] answer = {-1};
            return answer;
        }
        else{
            int[] answer = new int[stack.size()];
            for(int i = 0; i< answer.length;i++){
                answer[i] = stack.pop();
            }
            Arrays.sort(answer);
            return answer;
        }
    }
}