import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int K;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[1000000];
		bfs(N);
		System.out.println(arr[K]-1);
	}
	static void bfs(int N) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(N);
		arr[N] = 1;
		while(!q.isEmpty()) {
			int next = q.poll();
			if(next==K) {
				return;
			}
			if(2*next<arr.length&&arr[2*next]==0) {
				arr[2*next]=arr[next]+1;
				q.add(2*next);
			}
			if(next+1<arr.length&&arr[next+1]==0) {
				arr[next+1]=arr[next]+1;
				q.add(next+1);
			}
			if(next-1>=0&&arr[next-1]==0) {
				arr[next-1] = arr[next]+1;
				q.add(next-1);
			}
		}
	}
}