import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int[][] value;
	static int ans;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken()); //가로
		N = Integer.parseInt(st.nextToken()); //세로
		ans = Integer.MAX_VALUE;
		map = new int[N][M];
		value = new int[N][M];
		for(int i = 0;i<N;i++) {
			Arrays.fill(value[i], -1);
		}
		visited = new boolean[N][M];
		for(int i = 0; i<N;i++) {
			String s = bf.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j)-48;
			}
		}
		//dfs탐색	
		//dfs(0,0,0);
		bfs(0,0);
//		for(int[] e : value){
//			System.out.println(Arrays.toString(e));
//		}
		System.out.println(value[N-1][M-1]);
	}
	static void bfs(int y,int x) {
		ArrayDeque<Node> q = new ArrayDeque<>();
		q.add(new Node(y,x,0));
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(value[node.y][node.x]==-1) {
				value[node.y][node.x] = node.cnt;
			}
			else {
				if(value[node.y][node.x]>node.cnt) {
					value[node.y][node.x] = node.cnt;
				}
				else {
					continue;
				}
			}
			for(int i = 0; i<4;i++) {
				int ny = node.y+dy[i];
				int nx = node.x+dx[i];
				int cnt = node.cnt;
				if(ny>N-1||ny<0||nx>M-1||nx<0) continue;
				if(map[ny][nx]==1) {
					q.add(new Node(ny,nx,cnt+1));
				}
				if(map[ny][nx]==0) {
					q.add(new Node(ny,nx,cnt));
				}
			}
		}
	}
	static class Node{
		int y;
		int x;
		int cnt;
		public Node(int y,int x,int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
//	static void dfs(int y, int x,int cnt) {
//		if(cnt+1>=ans) {
//			return;
//		}
//		if(y==N-1&&x==M-1) {
//			ans = Math.min(cnt,ans);
//			return;
//		}
//		visited[y][x] = true;
//		for(int i = 0;i<4;i++) {
//			int ny = y + dy[i];
//			int nx = x + dx[i];
//			if(ny>N-1||ny<0||nx>M-1||nx<0)continue;
//			if(visited[ny][nx])continue;
//			if(map[ny][nx]==1) {
//				dfs(ny,nx,cnt+1);
//				visited[ny][nx]=false;
//			}else {
//				dfs(ny,nx,cnt);
//				visited[ny][nx]=false;
//			}
//		}
//	}
}