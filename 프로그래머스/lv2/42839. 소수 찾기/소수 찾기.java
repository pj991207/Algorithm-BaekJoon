import java.util.*;
class Solution {
    static int answer;
    static int N;
    static int R;
    static String[] nums;
    static String[] p;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        p = numbers.split("");
        N = p.length;
        for(int i = 1; i<=N;i++){
            R = i;
            visited = new boolean[N];
            nums = new String[R];
            Perm(0);
        }
        return answer;
    }
    static void Perm(int x){
        if(x==R){
            String str = "";
            for(int i = 0; i<R;i++){
                str += nums[i];
            }
            int num = Integer.parseInt(str);
            if(set.contains(num))return;
            if(!check(num)) return;
            set.add(num);
            if(num==1||num==0) return;
            answer+=1;
            return;
        }
        for(int i = 0; i<N;i++){
            if(visited[i]) continue;
            visited[i] = true;
            nums[x] = p[i];
            Perm(x+1);
            visited[i] = false;
        }
    }
    static boolean check(int x){
        for(int i = 2; i*i<=x;i++){
            if(x%i==0){
                return false;
            }
        }
        return true;
    }
}