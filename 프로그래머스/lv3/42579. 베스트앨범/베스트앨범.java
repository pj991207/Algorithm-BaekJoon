import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        
        //map을 사용해 장르별 play들의 합을 기록합니다.
        int  len = genres.length;
        for(int i = 0; i<len;i++){
            String genre = genres[i];
            Integer play = plays[i];
            if(map.containsKey(genre)){
                map.put(genre,map.get(genre)+play);
            }else{
                map.put(genre,play);
            }
        }
        //map의 value를 통해서 재생할 장르의 순서를 정합니다.
        String[] sequence = map.keySet().toArray(new String[map.size()]);
        Arrays.sort(sequence,(a,b)->map.get(b)-map.get(a));
        
        //장르안에서 많이 재생된 곡을 2개 선정합니다.
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer,Integer> music = new HashMap<>();
        for(int i = 0; i<sequence.length;i++){
            String check = sequence[i];
            int size = 0;
            for(String e : genres){
                if(e.equals(check)){
                    size++;
                }
            }
            Integer[] number = new Integer[size];
            int index = 0;
            for(int j = 0; j<genres.length;j++){
                if(genres[j].equals(check)){
                    number[index++] = plays[j];
                    music.put(j,plays[j]);
                }
            }
            Arrays.sort(number,Collections.reverseOrder());
            if(number.length > 1){
                queue.add(number[0]);
                queue.add(number[1]);
            }else{
                queue.add(number[0]);
            }
        }
        int[] answer = new int[queue.size()];
        Integer[] keyarr = music.keySet().toArray(new Integer[music.size()]);
        for(int i = 0; i<answer.length;i++){
            int z = queue.poll();
            for(int j = 0; j<keyarr.length;j++){
                if(keyarr[j]==-1){
                    continue;
                }
                if(music.get(keyarr[j]) == z){
                    answer[i] = keyarr[j];
                    keyarr[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}