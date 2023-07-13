import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<clothes.length;i++){
            String m = clothes[i][1];
            if(map.containsKey(m)){
                map.put(m,map.get(m)+1);
            }else{
                map.put(m,1);
            }
        }
        String[] arr = map.keySet().toArray(new String[map.size()]);
        int mux =1;
        for(int i = 0; i<arr.length;i++){
            int num = map.get(arr[i]);
            mux *= num+1;
        }
        answer = mux -1;
        return answer;
    }
}