import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static int M;
	static int T;
	static int[] R;
	static int[][] arr;
	static int[][] brr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		// 초기화
		init(bf);
		R = new int[T];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < T; i++) {
			R[i] = Integer.parseInt(st.nextToken());
		}
		rotate(R, T);
		print(arr);
	}

	static void init(BufferedReader bf) throws IOException {
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void print(int[][] a) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println("");
		}
	}

	static void rotate(int[] r, int t) {
		for (int i = 0; i < t; i++) {
			if (r[i] == 1) {
				first();
			}
			if (r[i] == 2) {
				second();
			}
			if (r[i] == 3) {
				third();
			}
			if (r[i] == 4) {
				four();
			}
			if (r[i] == 5) {
				five();
			}
			if (r[i] == 6) {
				six();
			}
		}
	}

	static void first() {
		brr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				brr[N - 1 - i][j] = arr[i][j];
			}
		}
		arr = brr;
	}

	static void second() {

		brr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				brr[i][M - 1 - j] = arr[i][j];
			}
		}
		arr = brr;
	}

	static void third() {
		brr = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				brr[j][N - 1 - i] = arr[i][j];
			}
		}
		arr = new int[M][N];
		arr = brr;
		int temp = M;
		M = N;
		N = temp;
	}

	static void four() {
		brr = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				brr[M - 1 - j][i] = arr[i][j];
			}
		}
		arr = new int[M][N];
		arr = brr;
		int temp = M;
		M = N;
		N = temp;
	}

	static void five() {
		brr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i >= 0 && i < N / 2 && j >= 0 && j < M / 2) {
					brr[i][j + M / 2] = arr[i][j];
				}
				if (i >= 0 && i < N / 2 && j >= M / 2 && j < M) {
					brr[i + N / 2][j] = arr[i][j];
				}
				if (i >= N / 2 && i < N && j >= M / 2 && j < M) {
					brr[i][j - M / 2] = arr[i][j];
				}
				if (i >= N / 2 && i < N && j >= 0 && j < M / 2) {
					brr[i - N / 2][j] = arr[i][j];
				}
			}
		}
		arr = brr;
	}

	static void six() {
		brr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i >= 0 && i < N / 2 && j >= 0 && j < M / 2) {
					brr[i + N / 2][j] = arr[i][j];
				}
				if (i >= 0 && i < N / 2 && j >= M / 2 && j < M) {
					brr[i][j - M / 2] = arr[i][j];
				}
				if (i >= N / 2 && i < N && j >= M / 2 && j < M) {
					brr[i - N / 2][j] = arr[i][j];
				}
				if (i >= N / 2 && i < N && j >= 0 && j < M / 2) {
					brr[i][j + M / 2] = arr[i][j];
				}
			}
		}
		arr = brr;
	}
}
