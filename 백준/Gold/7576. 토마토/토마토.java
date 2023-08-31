import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static ArrayDeque<Node> deq;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		deq = new ArrayDeque<Node>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					deq.add(new Node(i, j));
				}
			}
		}
		bfs();
		System.out.println(check());
	}
	static int check() {
		for(int i =0; i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					return -1;
				}
				cnt = Math.max(map[i][j],cnt);
			}
		}
		return cnt-1;
	}
	static void bfs() {
		while (!deq.isEmpty()) {
			Node node = deq.removeFirst();
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				if(ny>N-1||ny<0||nx>M-1||nx<0)continue;
				if(map[ny][nx]!=0)continue;
				map[ny][nx] = map[node.y][node.x]+1;
				deq.add(new Node(ny,nx));
			}
		}
	}

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}