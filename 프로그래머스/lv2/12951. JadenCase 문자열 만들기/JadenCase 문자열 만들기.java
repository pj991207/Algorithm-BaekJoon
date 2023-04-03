class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr= s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<arr.length;i++){
            String[] arr_s = arr[i].split("");
            sb.append(arr_s[0].toUpperCase());
            for(int j = 1; j<arr_s.length;j++){
                sb.append(arr_s[j].toLowerCase());
            }
            sb.append(" ");
        }
        if(s.substring(s.length()-1,s.length()).equals(" ")) return sb.toString();
        sb.deleteCharAt(sb.length()-1);
        answer = sb.toString();
        return answer;
    }
}