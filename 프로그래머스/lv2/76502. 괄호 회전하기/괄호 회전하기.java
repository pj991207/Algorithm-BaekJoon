import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        for(int i = 0; i<len;i++){
            int index = 0;
            Stack<Character> stack = new Stack<>();
            for(int j =0; j<len;j++){
                if(s.charAt(j)=='{'||s.charAt(j)=='['||s.charAt(j)=='('){
                    stack.push(s.charAt(j));
                }
                if(s.charAt(j)=='}'){
                    if(stack.empty()){
                        index = -1;
                        break;
                    }
                    if(stack.peek()=='{'){
                        stack.pop();
                    }
                }
                if(s.charAt(j)==']'){
                    if(stack.empty()){
                        index = -1;
                        break;
                    }
                    if(stack.peek()=='['){
                        stack.pop();
                    }
                }
                if(s.charAt(j)==')'){
                    if(stack.empty()){
                        index = -1;
                        break;
                    }
                    if(stack.peek()=='('){
                        stack.pop();
                    }
                }
                index++;
            }
            if(index == len){
                if(stack.empty()){
                    answer++;
                }
            }
            s = s.substring(1,len)+s.substring(0,1);
        }
        return answer;
    }
}