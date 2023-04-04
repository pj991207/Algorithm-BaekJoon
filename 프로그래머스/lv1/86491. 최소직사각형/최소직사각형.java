class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxh = 0;
        int maxv = 0;
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0]<sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            if(maxv<sizes[i][0]){
                maxv=sizes[i][0];
            }
            if(maxh<sizes[i][1]){
                maxh=sizes[i][1];
            }
        }
        answer = maxh*maxv;
        return answer;
    }
}