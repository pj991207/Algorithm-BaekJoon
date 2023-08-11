import java.util.*;
import java.io.*;

public class Main {
	static int[][] map = new int[100][100];
	static int N;
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					map[j+y][k+x] = 1;
				}
			}
		}
		for(int i = 0; i<100;i++) {
			for(int j =0;j<100;j++) {
				if(map[i][j]==1) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}