import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<String> set = new TreeSet<>();
        for(int i =0 ;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                String a = String.valueOf(numbers[i]+numbers[j]);
                set.add(a);    
            }
        }
        String[] temp = set.toArray(new String[0]);
        answer = new int[set.size()];
        for(int i =0;i<set.size();i++){
            answer[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(answer);
        return answer;
    }
}