import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int K;
	static int[][] dp;
	static int[] W;
	static int[] V;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		W = new int[N+1];
		V = new int[N+1];
		dp = new int[N+1][K+1];
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			W[i+1] = Integer.parseInt(st.nextToken());
			V[i+1] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i<=N;i++) {
			for(int j=1;j<=K;j++) { 
				if(j-W[i]>=0) {
					dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-W[i]]+V[i]);
					continue;
				}
				dp[i][j] = dp[i-1][j];
			}
		}
		System.out.println(dp[N][K]);
	}
}