import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static int cnt;
	static int house;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0;i<N;i++) {
			String line = bf.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=line.charAt(j)-48;
			}
		}
		for(int i = 0; i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1&&!visited[i][j]) {
					house = 0;
					dfs(i,j);
					pq.add(house);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		while(!pq.isEmpty()) {
			System.out.println(pq.remove());
		}
	}
	static void dfs(int y,int x) {
		visited[y][x] = true;
		house++;
		for(int i = 0; i<4;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny>N-1||ny<0||nx>N-1||nx<0) continue;
			if(visited[ny][nx]||map[ny][nx]==0) continue;
			dfs(ny,nx);
		}
	}
}