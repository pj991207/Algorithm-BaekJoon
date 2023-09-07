import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N+1][3];
		dp = new int[N+1][3];
		for(int i = 1 ;i <N+1;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j = 0;j<3;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1;i<N+1;i++) {
			dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+map[i][0];
			dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+map[i][1];
			dp[i][2] = Math.min(dp[i-1][1],dp[i-1][0])+map[i][2];
		}
		System.out.println(Math.min(Math.min(dp[N][0],dp[N][1]),dp[N][2]));	
	}
}