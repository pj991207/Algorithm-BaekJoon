class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown+yellow;
        for(int i=3; i<sum;i++){
            int x = 0;
            int y = 0;
            if(sum%i==0&&sum/i>=3){
                x = Math.max(sum/i,i);
                y = Math.min(sum/i,i);
                if((x-2)*(y-2) == yellow){
                    answer[0] = x;
                    answer[1] = y;
                    return answer;
                }
            }
        }
        return answer;
    }
}