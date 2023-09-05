import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] memo;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		memo = new int[2*N+2];
		dp(N);
		System.out.println(memo[N]%10007);
	}
	static void dp(int n) {
		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 2;
		for(int i = 3; i<N+1;i++) {
			memo[i] = memo[i-1]%10007+memo[i-2]%10007;
		}
	}
}