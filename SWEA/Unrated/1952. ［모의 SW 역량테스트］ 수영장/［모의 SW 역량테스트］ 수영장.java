import java.util.*;
import java.io.*;

public class Solution {
	static int T;
	static int[] fee;
	static int[] arr;
	static int MIN;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			sb.append("#").append(i + 1).append(" ");
			fee = new int[4];
			arr = new int[17];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j = 0; j <4;j++) {
				fee[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<12;j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			MIN = fee[3];
			dfs(0,0);
			sb.append(MIN).append("\n");
		}
		System.out.println(sb);
	}
	static void dfs(int sum,int month) {
		if(month>=12) {
			MIN = Math.min(sum,MIN);
			return;
		}
		dfs(sum+fee[0]*arr[month],month+1);
		dfs(sum+fee[1],month+1);
		dfs(sum+fee[2],month+3);
	}
}