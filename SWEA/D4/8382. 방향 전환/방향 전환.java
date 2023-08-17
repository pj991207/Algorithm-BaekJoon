import java.util.*;
import java.io.*;

public class Solution {
	
	static int T;
	static int N = 200;
	static int x1,x2,y1,y2;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<T;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			sb.append("#").append(i+1).append(" ");
			y1 = Integer.parseInt(st.nextToken())+100;
			x1 = Integer.parseInt(st.nextToken())+100;
			y2 = Integer.parseInt(st.nextToken())+100;
			x2 = Integer.parseInt(st.nextToken())+100;
			//Reading
			//로직시작
			visited = new int[N+1][N+1][2];
			Queue<int []>que= new ArrayDeque<>();
			que.add(new int[] {x1,y1,0,0}); //거리 방향 dir = 0, d = 0,2, d = 1,3  양옆
			que.add(new int[] {x1,y1,0,1}); //거리 방향 dir = 1, d = 0,2, d = 1,3 위아래
			visited[x1][y1][0]=1; // dir 0
			visited[x1][y1][0]=1; // dir 1
			int value = -1;
			while(!que.isEmpty()) {
				int[] cur = que.poll();
				int r = cur[0];
				int c = cur[1];
				int cnt = cur[2];
				int dir =cur[3];
				if(r==x2&&c==y2) {
					value =cnt;
					break;
				}
				for(int d= 1; d< 4;d+=2) {
					int s = (dir+d)%4;
					int u = (dir+d)%2;
					int nr = r+dr[s];
					int nc = c+dc[s];
					if(!check(nr,nc))continue;
					if(visited[nr][nc][u]==0) {
						visited[nr][nc][u]=1;
						que.offer(new int[] {nr,nc,cnt+1,u});
					}
				}
			}
			sb.append(value).append("\n");
		}
		System.out.println(sb);
	}
	static boolean check(int r, int c) {
		return r>=0&&r<N+1 &&c>=0&&c<N+1;
	}
}