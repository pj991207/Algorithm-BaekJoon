import java.util.*;
import java.io.*;

public class Main {
	static int w;
	static int h;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {-1,-1,0,1,1,1,0,-1};
	static int[] dx = {0,1,1,1,0,-1,-1,-1};
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			cnt = 0;
			if(w==0&&h==0) {
				break;
			}
			map = new int[h][w];
			visited = new boolean[h][w];
			for(int i = 0; i<h;i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j = 0;j<w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i =0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(visited[i][j]||map[i][j]==0)continue;
					bfs(i,j);
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
	static void bfs(int y,int x) {
		visited[y][x] = true;
		Queue<Pos> q = new ArrayDeque<>();
		q.add(new Pos(y,x));
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			for(int i =0 ;i<8;i++) {
				int ny = pos.y+dy[i];
				int nx = pos.x+dx[i];
				if(ny>=0&&ny<h&&nx>=0&&nx<w&&map[ny][nx]==1&&!visited[ny][nx]) {
					visited[ny][nx] = true;
					q.add(new Pos(ny,nx));
				}
			}
		}
	}
	static class Pos{
		int y;
		int x;
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}