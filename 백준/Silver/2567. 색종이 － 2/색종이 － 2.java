import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map = new int[102][102];
	static int ans = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j = 0; j<10;j++) {
				for(int k = 0; k<10;k++) {
					map[y+k+1][x+j+1] = 1;
				}
			}
		}
		for(int j = 1; j<102;j++) {
			for(int k = 1;k<102;k++) {
				if(map[j-1][k]!=map[j][k]) {
					ans++;
				}
				if(map[j][k-1]!=map[j][k]) {
					ans++;
				}
				
			}
		}
		System.out.println(ans);
	}
}