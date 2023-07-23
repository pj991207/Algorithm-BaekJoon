import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[] score;
	static ArrayList<Integer>[] graph;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		//배열 초기화
		arr = new int[N][M];
		for(int i = 0;i<N;i++) {
			String[] line = bf.readLine().split("");
			for(int j =0;j<M;j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}
		}
		//인접리스트 초기화
		graph = new ArrayList[N*M];
		for(int i = 0;i<N*M;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				for(int k = 0; k<4;k++) {
					int y = i+dy[k];
					int x = j + dx[k];
					if(x>=0&&x<M&&y>=0&&y<N&&arr[y][x]==1) {
						graph[i*M+j].add(y*M+x);
					}
				}
			}
		}
		score = new int[N*M];
		for(int i =0 ; i<N;i++) {
			for(int j =0;j<M;j++) {
				score[i*M+j] = 100000;
			}
		}
		//bfs를 통해서 최적의 거리 탐색
		bfs(0,0);
		System.out.println(score[N*M-1]);
	}
	static void bfs(int x, int cnt) {
		Queue<Integer> seq = new LinkedList<>();
		Queue<Integer> num = new LinkedList<>();
		score[x] = ++cnt;
		seq.add(x);
		num.add(cnt);
		while(!seq.isEmpty()) {
			int pos = seq.poll();
			int val = num.poll();
			for(int i = 0; i<graph[pos].size();i++) {
				int nextpos = graph[pos].get(i);
				int nextval = val+1;
				if(score[nextpos]>nextval) {
					score[nextpos] = nextval;
					seq.add(nextpos);
					num.add(nextval);
				}
			}
		}
	}
}