import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int[][] arr;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		arr = new int[M][N];
		// 초기화
		init(bf);
		// BFS를 통한 탐색
		bfs(new Pos(0, 0));
		// 출력
		System.out.println(arr[M - 1][N - 1]);
	}

	static void init(BufferedReader bf) throws Exception {
		for (int i = 0; i < M; i++) {
			String[] st = bf.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st[j]);
			}
			Arrays.fill(arr[i], -1);
		}
	}

	static void bfs(Pos pos) {
		Queue<Pos> qu = new LinkedList<>();
		Queue<Pos> next_qu = new LinkedList<>();
		arr[pos.y][pos.x] = 0;
		qu.add(pos);
		while (!qu.isEmpty()) {
			Pos p = qu.poll();
			for (int i = 0; i < 4; i++) {
				int y = p.y + dy[i];
				int x = p.x + dx[i];
				if (x >= 0 && x < N && y >= 0 && y < M) {
					if (arr[y][x] == -1) {
						if (map[y][x] == 1) {
							arr[y][x] = arr[p.y][p.x] + 1;
							// map[y][x]=0;
							next_qu.add(new Pos(y, x));
						} else {
							arr[y][x] = arr[p.y][p.x];
							qu.add(new Pos(y, x));
						}
					} else {
						if (map[y][x] == 1) {
							if (arr[y][x] > arr[p.y][p.x] + 1) {
								arr[y][x] = arr[p.y][p.x] + 1;
								next_qu.add(new Pos(y, x));
							}
						} else {
							if (arr[y][x] > arr[p.y][p.x]) {
								arr[y][x] = arr[p.y][p.x];
								qu.add(new Pos(y, x));
							}
						}
					}
				}
				if (qu.isEmpty()) {
					qu = next_qu;
					next_qu = new LinkedList<>();
				}
			}
		}
	}
}

class Pos {
	int y;
	int x;

	public Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
