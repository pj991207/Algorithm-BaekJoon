import java.util.*;
import java.io.*;

public class Main {
	static long MAX;
	static String maxStr;
	static long MIN;
	static String minStr;
	static int N;
	//static int[] p = {0,1,2,3,4,5,6,7,8,9};
	static int[] nums;
	static boolean[] visited;
	static String[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new String[N];
		visited = new boolean[10];
		nums = new int[N+1];
		MAX = 0;
		MIN = (long)Math.pow(10,N+1);
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N;i++) {
			arr[i] = st.nextToken();
		}
		Perm(0);
		System.out.println(maxStr);
		System.out.println(minStr);
	}
	static void Perm(int cnt) {
		if(cnt==N+1) {
			for(int i = 0; i<N;i++) {
				String check = arr[i];
				int a = nums[i];
				int b = nums[i+1];
				if(check.equals("<")) {
					if(a>b) {
						return;
					}
				}
				if(check.equals(">")) {
					if(a<b) {
						return;
					}
				}
			}
			
			String str = "";
			for(int i = 0;i<N+1;i++) {
				str += String.valueOf(nums[i]);
			}
			long ans = Long.parseLong(str);
			
			if(MAX<ans) {
				maxStr = str;
				MAX = ans;
			}
			if(MIN>ans) {
				minStr= str;
				MIN = ans;
			}
			return;
		}
		for(int i = 0 ; i<10;i++) {
			if(visited[i])continue;
			visited[i] = true;
			nums[cnt]=i;
			Perm(cnt+1);
			visited[i] = false;
		}
	}
}