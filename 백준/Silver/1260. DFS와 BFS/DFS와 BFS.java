import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int S;
	static ArrayList<Integer>[] arr;
	static boolean[] check;

	static Queue<Integer> qu = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		for(int i = 0; i<N+1;i++){
			arr[i] = new ArrayList<>();
		}
		check = new boolean[N+1];
		for(int i = 0; i<M;i++){
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}
		for(int i =0;i<N+1;i++){
			Collections.sort(arr[i]);
		}
		dfs(S);
		sb.append("\n");
		check = new boolean[N+1];
		bfs(S);
		System.out.println(sb);
	}
	static void dfs(int x){
		check[x] = true;
		sb.append(x+" ");
		for(int i = 0; i<arr[x].size();i++){
			int y = arr[x].get(i);
			if(check[y] ==false){
				dfs(y);
			}
		}
	}
	static void bfs(int x){
		check[x] = true;
		qu.add(x);
		while(!qu.isEmpty()){
			int y = qu.poll();
			sb.append(y+" ");
			for(int i=0;i<arr[y].size();i++){
				int z = arr[y].get(i);
				if(check[z] == false){
					check[z] = true;
					qu.add(z);
				}
			}
		}
	}
}
