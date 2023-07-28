import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int K;
	static int len;
	static int[] arr;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[200000];
		Arrays.fill(arr,-1);
		len = arr.length;
		bfs(N);
		System.out.println(arr[K]);
	}
	static void bfs(int x) {
		arr[x] = 0;
		q.add(x);
		while(!q.isEmpty()) {
			int y = q.poll();
			int a = y+1;
			int b = y-1;
			int c = y*2;
			change(y,a);
			change(y,b);
			change(y,c);
		}
	}
	static void change(int y,int a) {
		if(a>=0&&a<len) {
			if(arr[a]==-1) {
				arr[a]=arr[y]+1;
				q.add(a);
			}
		}
	}
}
