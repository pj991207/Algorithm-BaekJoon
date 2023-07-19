import java.util.*;
import java.io.*;
public class Main
{
	static int N;
	static int M;
	static int S;
	static ArrayList<Integer>[] arr;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> qu = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		for(int i = 0; i<N+1;i++){
			arr[i] = new ArrayList<>();
		}
		for(int i = 0; i<M;i++){
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		check = new boolean[N+1];
		int answer = 0;
		for(int i = 1; i<N+1;i++){
			if(check[i]==false){
				dfs(i);
				answer++;
			}
		}
		System.out.println(answer);
	}
	static void dfs(int x){
		check[x] = true;
		for(int i = 0; i<arr[x].size();i++){
			int y = arr[x].get(i);
			if(check[y]==false){
				dfs(y);
			}
		}
	}
}
