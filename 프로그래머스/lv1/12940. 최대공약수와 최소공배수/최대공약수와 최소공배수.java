class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[1]=n*m;
        while(m!=0){
            int temp = n;
            n = m;
            m = temp%m;
        }
        answer[0] = n;
        answer[1] = answer[1]/answer[0];
        return answer;
    }
}