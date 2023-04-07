import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();
        for(int i = 0; i<progresses.length;i++){
            int num = (100-progresses[i])/speeds[i];
            if(((100-progresses[i])%speeds[i])!=0){
                num += 1;
            }
            queue.add(num);
        }
        int max = queue.peek();
        while(!queue.isEmpty()){
            int cnt = 0;
            while(max>=queue.peek()){
                queue.remove();
                cnt++;
                if(queue.isEmpty()){
                    result.add(cnt);            
                    break;
                }
            }
            if(queue.isEmpty()){
                break;
            }
            result.add(cnt);            
            max = queue.peek();
        }
        int[] answer =new int[result.size()];
        for(int i = 0; i< answer.length;i++){
            answer[i] = result.poll();
        }
        return answer;
    }
}