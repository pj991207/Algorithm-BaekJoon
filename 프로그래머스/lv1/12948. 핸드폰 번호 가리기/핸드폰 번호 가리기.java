class Solution {
    public String solution(String phone_number) {
        String answer = "";
        String num = phone_number.substring(phone_number.length()-4,phone_number.length());
        String hide = "*".repeat(phone_number.length()-4);
        return hide+num;
    }
}