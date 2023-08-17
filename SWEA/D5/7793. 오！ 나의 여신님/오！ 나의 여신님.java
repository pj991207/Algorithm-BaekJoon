import java.util.*;
import java.io.*;

public class Solution {
	static int T;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int size;
	static int dsize;
	static int sy, sx, ly, lx;
	static int N;
	static int M;
	static int ans;
	static boolean flag;
	static List<Point> list;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			sb.append("#").append(i + 1).append(" ");
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			map = new int[N][M];
			ans = 0;
			flag = false;
			for (int j = 0; j < N; j++) {
				String s = bf.readLine();
				for (int k = 0; k < M; k++) {
					if (s.charAt(k) == 'X') {
						map[j][k] = 3;
					}
					if (s.charAt(k) == '.') {
						map[j][k] = 0;
					}
					if (s.charAt(k) == '*') {
						ly = j;
						lx = k;
						list.add(new Point(ly,lx));
					}
					if (s.charAt(k) == 'S') {
						sy = j;
						sx = k;
					}
					if (s.charAt(k) == 'D') {
						map[j][k] = 5;
					}
				}
			}
			bfs(new Point(sy, sx), list);
			if (flag)
				sb.append(ans).append("\n");
			if (!flag)
				sb.append("GAME OVER").append("\n");
		}
		System.out.println(sb);
	}

	static void bfs(Point person, List<Point> devil) {
		
		Queue<Point> qs = new ArrayDeque<>();
		Queue<Point> qd = new ArrayDeque<>();
		
		qs.add(person);
		map[person.y][person.x] = 1;
		
		size = qs.size();
		
		for(int i = 0; i<devil.size();i++) {
			Point d = devil.get(i);
			qd.add(d);
			map[d.y][d.x] = 2;
		}
		
		dsize = qd.size();
		
		while (!qs.isEmpty()&&!flag) {
//			for(int[] i : map) {
//				System.out.println(Arrays.toString(i));
//				System.out.println(ans);
//			}
//			System.out.println("");
			
			size = qs.size();
			ans++;
			for (int h = 0; h < size; h++) {
				Point p = qs.poll();

				if (map[p.y][p.x] != 1) {
					continue;
				}

				for (int i = 0; i < 4; i++) {
					int ny = p.y + dy[i];
					int nx = p.x + dx[i];

					if (ny >= 0 && ny < N && nx >= 0 && nx < M) {

						if (map[ny][nx] == 5) {
							flag = true;
							break;
						}

						if (map[ny][nx] == 0) {
							map[ny][nx] = 1;
							qs.add(new Point(ny, nx));
						}

					}
				}
			}
			
			dsize = qd.size();

			for (int h = 0; h < dsize; h++) {
				Point p = qd.poll();

//				if (!(map[p.y][p.x] == 2)) {
//					continue;
//				}

				for (int i = 0; i < 4; i++) {
					int ny = p.y + dy[i];
					int nx = p.x + dx[i];

					if (ny >= 0 && ny < N && nx >= 0 && nx < M) {

						if (map[ny][nx] == 0 || map[ny][nx] == 1) {

							map[ny][nx] = 2;

							qd.add(new Point(ny, nx));
						}
					}
				}
			}
		}
	}

	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}