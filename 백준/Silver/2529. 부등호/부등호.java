import java.util.*;
import java.io.*;

public class Main {
	static long MAX;
	static String maxStr;
	static long MIN;
	static String minStr;
	static int N;
	static int[] p;
	static int[] nums;
	static boolean[] visited;
	static String[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new String[N];
		MAX = 0;
		MIN = (long)Math.pow(10,N+1);
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N;i++) {
			arr[i] = st.nextToken();
		}
		
		visited = new boolean[10];
		p = new int[] {9,8,7,6,5,4,3,2,1,0};
		nums = new int[N+1];
		Perm(0);
		visited = new boolean[10];
		p = new int[] {0,1,2,3,4,5,6,7,8,9};
		Perm(0);
		
		System.out.println(sb);
	}
	
	static boolean Perm(int cnt) {
		if(cnt==N+1) {
			for(int i : nums) {
				sb.append(i);
			}
			sb.append('\n');
			return true;
		}
		for(int i = 0 ; i<10;i++) {
			if(visited[i])continue;
			visited[i] = true;
			nums[cnt]=p[i];
			if(cnt==0||compare(cnt)) {
				if(Perm(cnt+1)) return true;
			}
			visited[i] = false;
		}
		return false;
	}
	
	static boolean compare(int i){
		if(arr[i-1].equals("<")) {
			return nums[i-1]<nums[i];
		}
		if(arr[i-1].equals(">")) {
			return nums[i-1]>nums[i];
		}
		return true;
	}
}