import java.util.*;
import java.io.*;
public class Main {
	static int T;
	static int V;
	static int E;
	static ArrayList<Integer>[] arr;
	static int[] check;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<T;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			arr = new ArrayList[V+1];
			check = new int[V+1];
			for(int j=0;j<V+1;j++) {
				arr[j] = new ArrayList<>();
			}
			//그래프 초기화
			for(int j = 0; j<E;j++){
				st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[x].add(y);
				arr[y].add(x);
			}
			boolean answer = false;
			for(int j = 1; j<V+1;j++) {
				if(check[j]==0) {
					answer = dfs(j,1);
					if(!answer) {
						break;
					}
				}
			}
			if(answer) {
				sb.append("YES").append("\n");
			}else {
				sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	}
	static boolean dfs(int x,int point) {
		check[x] = point;
		for(int i = 0; i<arr[x].size();i++) {
			int y = arr[x].get(i);
			if(check[y] == check[x]) {
				return false;
			}else {
				if(check[y]==0) {
					if(dfs(y,3-check[x])==false) {
						return false;
					}
				}
			}
		}
		return true;
	}
	static boolean bfs(int x,int point) {
		q.add(x);
		check[x] = point;
		while(!q.isEmpty()) {
			int y = q.poll();
			for(int i = 0; i<arr[y].size();i++) {
				int z = arr[y].get(i);
				if(check[z]==check[y]) {
					return false;
				}else {
					if(check[z]==0) {
						check[z] = 3-check[y];
						q.add(z);
					}
				}
			}
		}
		return true;
	}
}
