import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int R;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		rotate(0, 0, N, M);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< N;i++) {
			for(int j = 0;j<M;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void rotate(int y, int x, int n, int m) {
		if (n == 0 || m == 0) {
			return;
		}
		int T = R%(2*m+2*n-4);
		for (int i = 0; i < T; i++) {
			int before = arr[y][x];
			int temp = 0;
			for (int j = 1; j < n; j++) {
				temp = arr[y + j][x];
				arr[y + j][x] = before;
				before = temp;
			}
			for (int j = 1; j < m; j++) {
				temp = arr[n - 1+y][x + j];
				arr[n - 1 + y][x + j] = before;
				before = temp;
			}
			for (int j = 1; j < n; j++) {
				temp = arr[n - 1 - j+y][m - 1+x];
				arr[n - 1 - j + y][m - 1 + x] = before;
				before = temp;
			}
			for (int j = 1; j < m; j++) {
				temp = arr[y][m - 1 - j + x];
				arr[y][m - 1 - j + x] = before;
				before = temp;
			}
		}
		rotate(y + 1, x + 1, n - 2, m - 2);
	}
}