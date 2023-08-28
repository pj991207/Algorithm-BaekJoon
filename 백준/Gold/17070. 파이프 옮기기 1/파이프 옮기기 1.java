import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		cnt = 0;
		for(int i = 0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,1,0);
		System.out.println(cnt);
	}
	static void dfs(int y, int x, int r) {
		if(y==N-1&&x==N-1) {
			cnt++;
			return;
		}
		if(r==0) {
			//가로인 경우
			//1.가로로이동
			if(x+1<N&&map[y][x+1]==0) {
				dfs(y,x+1,0);
			}
			//2.대각으로 이동
			if(x+1<N&&y+1<N&&map[y][x+1]==0&&map[y+1][x+1]==0&&map[y+1][x]==0) {
				dfs(y+1,x+1,2);
			}
		}
		if(r==1) {
			//세로인 경우
			//1.세로로이동
			if(y+1<N&&map[y+1][x]==0) {
				dfs(y+1,x,1);
			}
			//2.대각으로 이동
			if(x+1<N&&y+1<N&&map[y][x+1]==0&&map[y+1][x+1]==0&&map[y+1][x]==0) {
				dfs(y+1,x+1,2);
			}
		}
		if(r==2) {
			//대각선인 경우
			//1.가로로 이동
			if(x+1<N&&map[y][x+1]==0) {
				dfs(y,x+1,0);
			}
			//2.세로로 이동
			if(y+1<N&&map[y+1][x]==0) {
				dfs(y+1,x,1);
			}
			//3.대각으로 이동
			if(x+1<N&&y+1<N&&map[y][x+1]==0&&map[y+1][x+1]==0&&map[y+1][x]==0) {
				dfs(y+1,x+1,2);
			}
		}
	}
}