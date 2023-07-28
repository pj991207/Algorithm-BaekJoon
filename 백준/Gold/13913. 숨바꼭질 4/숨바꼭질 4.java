import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int K;
	static int[] arr;
	static final int MAX = 1000000;
	static Queue<Integer> qu = new LinkedList<>();
	static int[] log;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[MAX];
		log = new int[MAX];

		Arrays.fill(arr,-1);
		bfs(N);
		StringBuilder sb = new StringBuilder();
		sb.append(arr[K]+"\n");
		int x = K;
		Stack<Integer> stack = new Stack<>();
		while(log[x]!=x) {
			stack.push(x);
			x = log[x];
		}
		stack.push(x);
		while(!stack.isEmpty()) {
			int log = stack.pop();
			sb.append(log);
			sb.append(" ");
		}
		System.out.println(sb);
	}
	static void bfs(int x) {
		arr[x] = 0;
		log[x] = x;
		qu.add(x);
		while(!qu.isEmpty()) {
			int y = qu.poll();
			int a = y + 1;
			int b = y - 1;
			int c = y*2;
			change(y,a);
			change(y,b);
			change(y,c);
		}
	}
	static void change(int y,int a) {
		if(a>=0&&a<MAX) {
			if(arr[a]==-1) {
				arr[a] = arr[y]+1;
				qu.add(a);
				log[a] = y;
			}
		}
	}
}
