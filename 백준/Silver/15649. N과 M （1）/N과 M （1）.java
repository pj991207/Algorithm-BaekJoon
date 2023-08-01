import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int R;
	static int[] p;
	static int[] nums;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		p = new int[N];
		visited = new boolean[N];
		nums = new int[R];
		Arrays.setAll(p, i ->i+1);
		Perm(0);
		System.out.println(sb);
	}
	static void Perm(int c) {
		if(c==R) {
			for(int i =0; i<R;i++) {
				sb.append(nums[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0; i<N;i++) {
			if(visited[i])continue;
			visited[i]=true;
			nums[c]=p[i];
			Perm(c+1);
			visited[i]=false;
		}
	}
	
}
