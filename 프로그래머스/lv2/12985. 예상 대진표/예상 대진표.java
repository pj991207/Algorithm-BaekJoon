class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        while(n>0){
            int up = Math.max(a,b);
            int low = Math.min(a,b);
            if(up%2==0&&up-low==1){
                break;
            }
            if(a%2==0){
                a=a/2;
            }
            else{
                a= a/2+1;
            }
            if(b%2==0){
                b=b/2;
            }
            else{
                b=b/2+1;
            }
            n = n/2;
            answer++;
        }
        return answer;
    }
}