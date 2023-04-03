class Solution {
    public String solution(int n) {
        String answer = "";
        for(int i = 1; i<n+1;i++){
            if(i%2==0){
                answer = answer+"박";
            }
            else{
                answer = answer +"수";
            }
        }
        return answer;
    }
}