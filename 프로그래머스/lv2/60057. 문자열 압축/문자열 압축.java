class Solution {
    public int solution(String s) {
        int answer = s.length();
        int length = s.length();
        for(int i = 1; i<length; i++){
            int size = (int)Math.ceil((double)length/i);
            int index = 0;
            String[] arr = new String[size];
            for(int j = 0;j<length;j+=i){
                arr[index++] = s.substring(j,Math.min(j+i,length));
            }
            int result = splitSize(arr);
            answer = Math.min(answer,result);
        }
        return answer;
    }
    static int splitSize(String[] arr){
        String answer = "";
        String pivot = arr[0];
        int num = 1;
        for(int i = 1; i<arr.length;i++){
            if(pivot.equals(arr[i])){
                num++;
            }
            else{
                if(num==1){
                    answer += pivot;
                }else{
                    answer += String.valueOf(num)+pivot;
                }
                pivot = arr[i];
                num = 1;
            }
            if(i==arr.length-1){
                if(num==1){
                    answer += pivot;
                }else{
                    answer += String.valueOf(num)+pivot;
                }
            }
        }
        return answer.length();
    }
}