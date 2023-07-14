import java.util.*;
import java.io.*;

public class Main {
	static int T;
	static int N;
	static int[][] arr;
	static int d;
	static int r;
	static int c;

	static int depth;
	static int point;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(bf.readLine());
		T = Integer.parseInt(bf.readLine());
		arr = new int[N][N];
		d = 1;
		r = N / 2;
		c = N / 2;
		depth = 0;
		point = 0;
		String s = "";
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				arr[r][c] = j * N + k + 1;
				if(arr[r][c]==T){
					s = (r+1) + " " + (c+1);
				}
				depth = (int)Math.ceil((Math.pow(arr[r][c] + 1, 0.5) - 1) / 2);
				int a = r + dy[d];
				int b = c + dx[d];
				int positionR = Math.abs(a - N / 2);
				int positionC = Math.abs(b - N / 2);
				if (positionR <= depth && positionC <= depth && a >= 0 && a < N && b >= 0 && b < N && arr[a][b] == 0) {
					r = a;
					c = b;
					continue;
				} else {
					d++;
					d = d % 4;
					r = r + dy[d];
					c = c + dx[d];
				}
			}
		}
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				sb.append(arr[j][k] + " ");
			}
			sb.append("\n");
		}
		sb.append(s);
		System.out.println(sb);
	}
}
