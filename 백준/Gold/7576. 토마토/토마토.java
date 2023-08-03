import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[][] box;
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int day = 0;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		// 초기화
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j]==1){
					q.add(new int[]{i,j});
				}
			}
		}
		//탐색
		bfs();
		//확인
		check();
		
	}
	//bfs를 통해서 익은 토마토를 탐색합니다.
	static void bfs() {
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			for(int i = 0; i<4;i++) {
				int y = pos[0]+dy[i];
				int x = pos[1]+dx[i];
				if(x>=0&&x<M&&y>=0&&y<N&&box[y][x]==0) {
					box[y][x]=box[pos[0]][pos[1]]+1;
					day = box[y][x];
					q.add(new int[] {y,x});
				}
			}
		}
	}
	//안익은 토마토 확인 및 날짜 출력
	static void check() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(box[i][j]==0) {
					System.out.println(-1);
					return;
				}
			}
		}
		if(day==0) {
			System.out.println(0);
		}else {
			System.out.println(day-1);
		}
	}
}
