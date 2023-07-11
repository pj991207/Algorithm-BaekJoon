import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0){
            return cities.length*5;
        }
        
        String[] cache = new String[cacheSize];
        int[] time = new int[cacheSize];
        for(int i = 0; i<cacheSize;i++){
            cache[i] = "init";
        }
        
        for(int i=0;i<cities.length;i++){
            String city = cities[i].toLowerCase();
            int lrutime = time[0];
            int lruindex = 0;
            boolean check = false;
            for(int j=0;j<cache.length;j++){
                String cachecity = cache[j];
                if(cachecity.equals(city)){
                    time[j] = 0;
                    answer += 1;
                    check = true;
                }
                else{
                    time[j]++;
                }
            }
            for(int j = 0; j<cache.length;j++){
                if(lrutime<time[j]){
                    lruindex=j;
                    lrutime = time[j];
                }
            }
            if(!check){
                cache[lruindex] = city;
                time[lruindex] = 0;
                answer += 5;
            }
        }
        return answer;
    }
}