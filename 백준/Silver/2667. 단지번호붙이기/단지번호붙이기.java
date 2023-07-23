import java.util.*;
import java.io.*;
public class Main {
	static ArrayList<Integer>[] graph;
	static ArrayList<Integer> answer = new ArrayList<>();
	static int[][] arr;
	static boolean[] check;
	static int N;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(bf.readLine());
		arr = new int[N][N];
		//지도 초기화
		for(int i = 0; i< N;i++) {
			String[] st = bf.readLine().split("");
			for(int j = 0; j<N;j++){
				arr[i][j] = Integer.parseInt(st[j]);
			}
		}
		//인접리스트 초기화
		//지도가 2차원 배열이므로 N으로 나눈 목과 나머지를 통해 1차원 배열로 표현할 것임. --알칼제이...?
		graph = new ArrayList[N*N];
		for(int i = 0; i<N*N;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i<N;i++) {
			for(int j = 0 ;j<N;j++) {
				if(arr[i][j]!=0) {
					for(int k=0;k<4;k++) {
						int y = i+dy[k];
						int x = j+dx[k];
						if(x>=0&&x<N&&y>=0&&y<N&&arr[y][x]==1) {
							graph[i*N+j].add(y*N+x);
						}
					}
				}
			}
		}
		check = new boolean[N*N];
		//bfs를 통한 단지수 구하기
		for(int i = 0; i<graph.length;i++) {
			if(!check[i]&&arr[i/N][i%N]==1) {
				bfs(i);
			}
		}
		sb.append(answer.size());
		if(answer.size()==0) {
			sb.append("\n").append(0);
		}
		Collections.sort(answer);
		for(int i : answer) {
			sb.append("\n");
			sb.append(i);
		}
		System.out.println(sb);
	}
	static void bfs(int x) {
		check[x] = true;
		Queue<Integer> qu = new LinkedList<>();
		qu.add(x);
		int cnt = 1;
		while(!qu.isEmpty()) {
			int y = qu.poll();
			for(int i = 0; i<graph[y].size();i++) {
				int z = graph[y].get(i);
				if(!check[z]) {
					cnt++;
					check[z] = true;
					qu.add(z);
				}
			}
		}
		if(cnt >= 1) {
			answer.add(cnt);
		}
	}
}
