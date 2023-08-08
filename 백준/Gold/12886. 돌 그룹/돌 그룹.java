import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] visited = new boolean[1501][1501];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		System.out.println(bfs(a, b, c) ? 1 : 0);
	}

	static boolean bfs(int a, int b, int c) {
		if ((a + b + c) % 3 != 0) {
			return false;
		}
		Queue<Stone> q = new ArrayDeque<>();
		q.add(new Stone(a, b, c));
		visited[a][b] = true;
		while (!q.isEmpty()) {
			Stone stone = q.remove();
			int x = stone.a;
			int y = stone.b;
			int z = stone.c;
			if (x == y && y == z) {
				return true;
			}
			if (x != y) {
				int nx = x > y ? x - y : x + x;
				int ny = x > y ? y + y : y - x;
				if (!visited[nx][ny]) {
					q.add(new Stone(nx, ny, z));
					visited[nx][ny] = true;
				}
			}
			if (y != z) {
				int ny = y > z ? y - z : y + y;
				int nz = y > z ? z + z : z - y;
				if (!visited[ny][nz]) {
					q.add(new Stone(x, ny, nz));
					visited[ny][nz] = true;
				}
			}
			if (x != z) {
				int nx = x > z ? x - z : x + x;
				int nz = x > z ? z + z : z - x;
				if(!visited[nx][nz]) {
					q.add(new Stone(nx,y,nz));
					visited[nx][nz] = true;
				}
			}
		}
		return false;
	}

	static class Stone {
		int a;
		int b;
		int c;

		Stone(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
}