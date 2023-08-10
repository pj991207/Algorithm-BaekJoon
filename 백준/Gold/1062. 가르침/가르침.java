import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int M;
	static boolean[][] arr;
	static boolean[] dict;
	static int[] nums;
	static int MAX;
	static int valid;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		if(M<5) {
			System.out.println(0);
			System.exit(0);
		}
		
		MAX = 0;
		dict = new boolean[26];
		arr = new boolean[N][26];
		nums = new int[N];
		
		M = M - 5;
		dict['a'-'a'] = true;
		dict['n'-'a'] = true;
		dict['t'-'a'] = true;
		dict['i'-'a'] = true;
		dict['c'-'a'] = true;
		for(int i = 0; i<N;i++) {
			char[] charArr = bf.readLine().toCharArray();
			int cnt = 0;
			for(int j = 0; j<charArr.length;j++) {
				if(arr[i][charArr[j]-'a']==true) {
					continue;
				}
				arr[i][charArr[j]-'a'] = true;
				cnt++;
			}
			nums[i] = cnt-5;
		}
		dfs(0,0);
		System.out.println(MAX);
	}
	static void dfs(int cnt,int start) {
		if(cnt==M) {
			valid = 0;
			for(int i = 0; i<N;i++) {
				boolean flag = true;
				if(nums[i]>M) {
					continue;
				}
				for(int j = 0; j<26;j++) {
					if(arr[i][j]==true) {
						if(dict[j]!=true) {
							flag = false;
							break;
						}
					}
				}
				if(flag) {
					valid++;
				}
			}
			MAX = Math.max(MAX,valid);
			return;
		}
		for(int i = start; i<26;i++) {
			if(dict[i])continue;
			dict[i] = true;
			dfs(cnt+1,i+1);
			dict[i] = false;
		}
	}
}