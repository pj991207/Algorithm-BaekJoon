import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        String[] arr = s.split("");
        Stack<String> stack = new Stack<>();
        for(String i : arr){
            if(stack.empty()){
                stack.push(i);
            }else{
                            if(i.equals(stack.peek())){
                stack.pop();
            }
            else{
                stack.push(i);
            }    
            }
        }
        if(stack.empty()){
            answer = 1;
        }else{
            answer = 0;
        }
        return answer;
    }
}