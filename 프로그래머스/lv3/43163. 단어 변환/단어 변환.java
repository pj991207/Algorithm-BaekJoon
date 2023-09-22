import java.util.*;
import java.io.*;
class Solution {
    static int[] visited;
    static String[] words;
    static String target;
    static int answer;
    public int solution(String begin, String t, String[] w) {
        target = t;
        words = Arrays.copyOf(w,w.length);
        visited = new int[words.length];
        dfs(begin);
        return answer;
    }
    static void dfs(String str){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(str,-1));
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.str.equals(target)){
                answer = visited[node.index];
                return;
            }
            for(int i = 0; i<words.length;i++){
                if(visited[i]!=0) continue;
                if(check(node.str,words[i])){
                    q.add(new Node(words[i],i));
                    if(node.index==-1){
                        visited[i] = 1;
                        continue;
                    }
                    visited[i] = visited[node.index]+1;
                }
            }
        }
    }
    static class Node{
        String str;
        int index;
        public Node(String str, int index){
            this.str = str;
            this.index = index;
        }
    }
    static boolean check(String a, String b){
        int cnt = 0;
        for(int i = 0; i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                cnt++;
            }
        }
        if(cnt==1){
            return true;
        }
        return false;
    }
}