import java.util.*;
class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = len;
        for(int i = 1; i<len;i++){
            int size = (int)Math.ceil((double)len/i);
            String[] arr = new String[size];
            int index = 0;
            for(int j = 0;j<len;j=j+i){
                arr[index] = s.substring(j,Math.min(j+i,len));
                index = index + 1;
            }
            int sum = impl(arr);
            if(answer > sum){
                answer = sum;
            }
        } 
        return answer;
    }
    
    static int impl(String[] arr){
        int size = arr.length;
        String answer ="";
        String pivot = arr[0];
        int num = 1;
        for(int i = 1; i<size;i++){
            if(!pivot.equals(arr[i])){
                if(num==1){
                    answer+= pivot;
                }else{
                    answer += String.valueOf(num)+pivot;    
                }
                pivot = arr[i];
                num = 1;
            }else{
                num++;
            }
            if(i==size-1){
                if(num==1){
                    answer+= pivot;
                }else{
                    answer += String.valueOf(num)+pivot;    
                }
            }
        }
        return answer.length();
    }
}