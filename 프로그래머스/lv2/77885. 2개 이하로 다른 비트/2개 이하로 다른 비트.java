class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i<numbers.length;i++){
            answer[i] = search(numbers[i]);
        }
        return answer;
    }
    static long search(long num){
        long comp = 1;
        while(true){
            if(num != (num|comp)){
                if(comp==1){
                    return num+1;
                }
                num = num|comp;
                num = num^(comp/2);
                return num;
            }
            comp = 2*comp;
        }
    }
}