import java.util.*;
class Solution {
    static int N;
    static int M;
    static int answer = 0;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int[][] map;
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        map = new int[N][M];
        for(int i = 0; i<N;i++){
            map[i] = Arrays.copyOf(maps[i],M);
        }
        bfs(new Node(0,0,0));
        if(map[N-1][M-1]==1){
            answer = -1;
        }
        return answer;
    }
    static void bfs(Node node){
        Queue<Node> q = new ArrayDeque<>();
        map[node.y][node.x] = 0;
        node.answer++;
        q.add(node);
        while(!q.isEmpty()){
            Node n = q.poll();
            if(n.y==N-1&&n.x==M-1){
                answer = n.answer;
                return;
            }
            for(int i = 0; i< 4;i++){
                int ny = n.y+dy[i];
                int nx = n.x+dx[i];
                if(ny<0||ny>N-1||nx<0||nx>M-1)continue;
                if(map[ny][nx]==0)continue;
                map[ny][nx] = 0;
                q.add(new Node(ny,nx,n.answer+1));
            }
        }
    }
    static class Node{
        int y;
        int x;
        int answer;
        public Node(int y,int x,int answer){
            this.y = y;
            this.x = x;
            this.answer = answer;
        }
    }
}