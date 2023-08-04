import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int A = 0;// 위아래
	static int B = 0;// 양옆
	static int C = 0;// 앞뒤
	static int ans = 0;
	static int[] dx = { 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		// 정육면체에 대한 입력을 초기화 하는 동시에 겉넓이 중에 위와 아래의 값을 구합니다.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					continue;
				A += 1;
			}
		}
		//System.out.println(A);
		ans += 2 * A;
		frontback();
		leftright();
		System.out.println(ans);
	}

	// 정육면체의 양옆을 구하는 함수입니다.
	static void leftright() {
		for (int i = 0; i < N; i++) {
			int MIN = 101;
			int[] len = new int[M];
			int cnt = 0;
			for (int j = 0; j < M; j++) {
				MIN = Math.min(MIN, map[i][j]);
			}
			for (int j = 0; j < M; j++) {
				len[j] = map[i][j] - MIN;
			}
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 2; k++) {
					int x = j + dx[k];
					if (x >= 0 && x < M) {
						if (len[j] > len[x]) {
							cnt += len[j] - len[x];
						}
					}
					if(x==-1 || x==M) {
						cnt += len[j];
					}
				}
			}
			B += (2 * MIN + cnt);
		}
		ans += B;
	}

	// 정육면체의 앞과 뒤를 구하는 함수입니다.
	static void frontback() {
		for (int i = 0; i < M; i++) {
			// int MAX = 0;
			int MIN = 101;
			int[] len = new int[N];
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				// MAX = Math.max(MAX,map[j][i]);
				MIN = Math.min(MIN, map[j][i]);
			}
			for (int j = 0; j < N; j++) {
				len[j] = map[j][i] - MIN;
			}
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 2; k++) {
					int x = j + dx[k];
					if (x >= 0 && x < N) {
						if (len[j] > len[x]) {
							cnt += len[j] - len[x];
						}
					}
					if(x==-1 || x==N) {
						cnt += len[j];
					}
				}
			}
			C += (2 * MIN + cnt);
		}
		ans += C;
	}
}
