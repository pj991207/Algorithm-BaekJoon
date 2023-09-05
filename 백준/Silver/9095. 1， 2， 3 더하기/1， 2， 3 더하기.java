import java.util.*;
import java.io.*;
public class Main {
	static int T;
	static int N;
	static int[] memo;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		memo = new int[12];
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		for(int i = 0; i<T;i++) {
			N = Integer.parseInt(bf.readLine());
			dp(N);
			sb.append(memo[N]).append("\n");
		}
		System.out.println(sb);
	}
	static void dp(int n) {
		for(int i = 4; i<n+1;i++) {
			memo[i] = memo[i-2]+memo[i-1]+memo[i-3];
		}
	}
}