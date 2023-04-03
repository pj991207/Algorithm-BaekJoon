class Solution {
    public boolean solution(int x) {
        String s = String.valueOf(x);
        String[] arr_s = s.split("");
        boolean answer = true;
        int num = 0;
        for(String k : arr_s){
            num = num + Integer.parseInt(k);
        }
        if(x%num != 0){
            answer = false;
        }
        return answer;
    }
}