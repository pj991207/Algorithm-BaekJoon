import java.util.*;
class Solution {
    static List<String> list = new ArrayList<>();
    static String[] wordlist = {"A","E","I","O","U"};
    
        
    public int solution(String word) {
        int answer = 0;
        dfs(0,"");
        for(int i = 0; i<list.size();i++){
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    static void dfs(int depth, String str){
        list.add(str);
        if(depth==5){
            return;
        }
        for(int i = 0; i<wordlist.length;i++){
            dfs(depth+1,str+wordlist[i]);
        }
    }
}