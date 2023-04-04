class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        int zero = 0;
        while(!s.equals("1")){
            String[]arr = s.split("0");
            StringBuilder sb = new StringBuilder();
            for(String i : arr){
                sb.append(i);
            }
            zero += s.length() - sb.toString().length();
            s = sb.toString();
            int num = s.length();
            sb = new StringBuilder();
            while(num!=1){
                if(num%2==0){
                    sb.append("0");
                }
                else{
                    sb.append("1");
                }
                num = num/2;
            }
            sb.append("1");
            s = sb.reverse().toString();
            cnt++;
        }
        answer[0] = cnt;
        answer[1] = zero;
        return answer;
    }
}