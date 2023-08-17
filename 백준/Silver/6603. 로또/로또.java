import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] nums;
	static int[] ans;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			
			if(N==0) break;
			
			ans = new int[6];
			nums = new int[N];
			
			for(int i = 0; i<N;i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0);
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	static void dfs(int index, int start) {
		if(index == 6) {
			for(int i : ans) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = start; i<N;i++) {
			ans[index] = nums[i];
			dfs(index+1,i+1);
		}
		
	}
}