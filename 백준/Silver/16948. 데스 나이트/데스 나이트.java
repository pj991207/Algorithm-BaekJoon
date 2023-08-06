import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	static int Y;
	static int X;
	static int R;
	static int C;
	static int ans;
	static int[] dy = { -2, -2, 0, 0, 2, 2 };
	static int[] dx = { -1, 1, -2, 2, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		bfs(Y, X);
		ans = map[R][C]-1;
		sb.append(ans); //처음 map의 초기화가 0의 값이므로 이동할 수 없는 경우 자동으로 -1이됨.
		System.out.println(sb);
	}
	//bfs를 이용한 최단거리 탐색 시작을 1로 생각함 즉 나중에 (r,c)에 값을 -1할 예정
	static void bfs(int y, int x) {
		Queue<int[]> q = new ArrayDeque<>();
		map[y][x] = 1;
		q.add(new int[] { y, x });
		while (!q.isEmpty()) {
			int[] pos = q.remove();
			int pos_y = pos[0];
			int pos_x = pos[1];
			for (int i = 0; i < 6; i++) {
				int next_y = pos_y + dy[i];
				int next_x = pos_x + dx[i];
				if (next_x >= 0 && next_x < N && next_y >= 0 && next_y < N && map[next_y][next_x] == 0) {
					map[next_y][next_x] = map[pos_y][pos_x] + 1;
					q.add(new int[] {next_y,next_x});
				}
				//탈출조건
				if(next_y==R&&next_x==C) {
					return;
				}
			}
		}
	}
}
