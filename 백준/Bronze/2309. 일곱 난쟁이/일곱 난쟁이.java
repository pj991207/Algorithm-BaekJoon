import java.util.*;
import java.io.*;

public class Main {
	static int N = 9;
	static int R = 7;
	static int[] p;
	static int[] nums;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		visited = new boolean[N];
		p = new int[N];
		nums = new int[R];
		for(int i = 0; i<N;i++) {
			p[i] = Integer.parseInt(bf.readLine());
		}
		Perm(0,0);
	}
	static void Perm(int n,int sum) {
		if(n==R) {
			if(sum == 100) {
				Arrays.sort(nums);
				for(int e : nums) {
					System.out.println(e);
				}
				System.exit(0);
			}
			return;
		}
		for(int i = 0; i<N;i++) {
			if(visited[i]) return;
			visited[i] = true;
			nums[n] = p[i];
			Perm(n+1,sum+p[i]);
			visited[i] = false;
		}
	}
}