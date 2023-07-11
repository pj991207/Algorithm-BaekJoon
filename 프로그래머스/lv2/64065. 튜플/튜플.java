import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        s = s.substring(1,s.length()-1);
        String[] tuple = s.split("}");
        tuple[0] = tuple[0].substring(1,tuple[0].length());
        for(int i = 1; i<tuple.length;i++){
            tuple[i] = tuple[i].substring(2,tuple[i].length());
        }
        for(int i = 0; i<tuple.length-1;i++){
            int point = i;
            for(int j = i+1; j<tuple.length;j++){
                if(tuple[point].length()>tuple[j].length()){
                    point = j;
                }
            }
            String temp = tuple[i];
            tuple[i] = tuple[point];
            tuple[point] = temp;
        }
        answer = new int[tuple.length];
        answer[0] = Integer.parseInt(tuple[0]);
        for(int i = 1; i<tuple.length;i++){
            String[] temp = tuple[i].split(",");
            for(int j = 0; j< temp.length;j++){
                for(int k = 0;k < answer.length;k++){
                    if(temp[j].equals(String.valueOf(answer[k]))){
                        temp[j] = "empty";
                    }
                }
            }
            for(int j =0;j<temp.length;j++){
                if(!temp[j].equals("empty")){
                    answer[i] = Integer.parseInt(temp[j]);
                }
            }
        }
        return answer;
    }
}