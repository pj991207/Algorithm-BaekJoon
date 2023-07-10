class Solution {
    public int[] solution(int n, long left, long right) {
        int diff = (int)(right-left);
        int[] answer = new int[diff+1];
        int index = 0;
        for(long i = left; i<=right; i++){
            int m = (int)(i/n);
            int h = (int)(i%n);
            int point = h+1;
            if(point < m+1){
                point = m+1;
            }
            answer[index] = point;
            index++;
        }
        return answer;
    }
}