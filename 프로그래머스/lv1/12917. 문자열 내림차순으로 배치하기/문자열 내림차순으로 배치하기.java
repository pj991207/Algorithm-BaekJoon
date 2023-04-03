import java.util.*;
class Solution {
    public String solution(String s) {
        String[] arr_s = s.split("");
        Arrays.sort(arr_s);
        StringBuilder sb = new StringBuilder();
        for(String i : arr_s){
            sb.append(i);
        }
        return sb.reverse().toString();
    }
}