import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[][] map;
	static boolean[][][] visited;
	static int MIN = 1000000;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i<N;i++) {
			String line = bf.readLine();
			for(int j = 0; j<M;j++) {
				map[i][j]= (int)('0'-line.charAt(j));
			}
		}
		visited = new boolean[N][M][2];
		MIN = bfs(new Pos(0,0,0,1));
		
		System.out.println(MIN);
	}
	static int bfs(Pos pos) {
		Queue<Pos> q = new ArrayDeque<>();
		q.add(pos);
		visited[pos.y][pos.x][0]=true;
		visited[pos.y][pos.x][1]=true;
		while(!q.isEmpty()) {
			Pos p = q.poll();
			if(p.y==N-1&&p.x==M-1) {
				return p.sum;
			}
			for(int i = 0; i<4;i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if(ny>=0&&ny<N&&nx>=0&&nx<M) {
					if(map[ny][nx]==0 && !visited[ny][nx][p.block]) {
						visited[ny][nx][p.block] = true;
						q.add(new Pos(ny,nx,p.block,p.sum+1));
					}
					if(map[ny][nx]==-1 && p.block==0) {
						visited[ny][nx][1] = true;
						q.add(new Pos(ny,nx,p.block+1,p.sum+1));
					}
				}
			}
		}
		return -1;
	}
	static class Pos{
		int y;
		int x;
		int block;
		int sum;
		public Pos(int y,int x,int block,int sum) {
			this.y = y;
			this.x = x;
			this.block = block;
			this.sum = sum;
		}
	}
}