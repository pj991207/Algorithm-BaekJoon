import java.util.*;
import java.io.*;
public class Main {
	static int[][] floor;
	static int N;
	static int M;
	static int R;
	static int C;
	static int dir;
	static int clean;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		floor= new int[N][M];
		clean = 0;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<M;j++) {
				floor[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cleanup();
		System.out.println(clean);
	}
	static void cleanup() {
		while(true) {
			if(floor[R][C]==0) {
				floor[R][C] = -1;
				clean++;
			}
			boolean flag = check();
			if(flag) {
				int go = (dir+2)%4;
				int tempR = R + dy[go];
				int tempC = C + dx[go];
				if(floor[tempR][tempC]==1) {
					return;
				}else {
					R = tempR;
					C = tempC;
				}
			}else {
				dir = (dir+3)%4;
				int tempR = R+dy[dir];
				int tempC = C+dx[dir];
				if(floor[tempR][tempC]==0) {
					R = tempR;
					C = tempC;
				}
			}
		}
	}
	//4방향 청소안된곳이 있다면 false 아니면 true
	static boolean check() {
		for(int i =0;i<4;i++) {
			int y = R + dy[i];
			int x = C + dx[i];
			if(floor[y][x]==0) {
				return false;
			}
		}
		return true;
	}
}
