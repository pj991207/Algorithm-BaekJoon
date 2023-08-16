import java.util.*;
import java.io.*;

public class Main {
	static int R;
	static int C;
	static int[][] map;
	//static Set<int[]> set = new HashSet<>();
	static int[] dy = {-1,0,1};
	static int[] dx = {1,1,1};
	static int ans = 0;
	static boolean flag = false;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for(int i = 0; i<R;i++) {
			String[] arr = bf.readLine().split("");
			for(int j = 0; j<C;j++) {
				if(arr[j].equals(".")) {
					map[i][j]=0;
				}
				if(arr[j].equals("x")) {
					map[i][j]=1;
				}
			}	
		}
		
		for(int i = 0; i<R;i++) {
			flag = false;
			dfs(i,0);
		}
		System.out.println(ans);
	}
	static void dfs(int y, int x) {
		if(x==C-1) {
			ans++;
			flag = true;
			return;
		}
		for(int i = 0; i<3;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			if(ny>=0&ny<R&&nx>=0&&nx<C&&!flag) {
				if(map[ny][nx]==0) {
					map[ny][nx]=1;
					dfs(ny,nx);
				}
			}
		}
	}
	static class Point{
		int y;
		int x;
		public Point(int y,int x) {
			this.y = y;
			this.x = x;
		}
	}
}