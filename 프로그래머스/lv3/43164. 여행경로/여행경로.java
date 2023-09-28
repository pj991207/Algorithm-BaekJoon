import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<String> list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs("ICN","ICN",0,tickets);
        Collections.sort(list);
        String[] answer = list.get(0).split(" ");
        return answer;
    }
    static void dfs(String to,String path,int cnt,String[][] tickets){
        if(cnt==visited.length){
            list.add(path);
            return;
        }
        for(int i = 0; i< tickets.length;i++){
            if(visited[i]||!tickets[i][0].equals(to))continue;
            visited[i] = true;
            dfs(tickets[i][1],path+" "+tickets[i][1],cnt+1,tickets);
            visited[i] = false;
        }
    }

}