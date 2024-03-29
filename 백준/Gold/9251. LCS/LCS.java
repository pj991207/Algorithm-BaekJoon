import java.util.*;
import java.io.*;

public class Main {
	static String a;
	static String b;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		a = bf.readLine();
		b = bf.readLine();
		dp = new int[a.length()+1][b.length()+1];

		for(int i = 1; i <= a.length(); i++) {
			for(int j = 1;j<=b.length();j++) {
				if(a.charAt(i-1)==b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
					continue;
				}
				dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		System.out.println(dp[a.length()][b.length()]);
	}
}