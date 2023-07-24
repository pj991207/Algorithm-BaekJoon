import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int L;
	static int R;
	static int[][] arr;
	static ArrayList<Integer>[] graph;
	static boolean[] valid;
	static Queue<Integer> seq;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<N;j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		while(true) {
			if(init()) {
				cnt++;
			}else {
				break;
			}
			for(int i = 0; i<N*N;i++) {
				if(!valid[i]) {
					bfs(i);
					if(!seq.isEmpty()) {
						int size = seq.size();
						int sum = 0;
						for(int j = 0; j<size;j++) {
							int x = seq.poll();
							sum += arr[x/N][x%N];
							seq.add(x);
						}
						sum = sum/size;
						for(int j = 0; j<size;j++) {
							int x = seq.poll();
							arr[x/N][x%N] = sum; 
						}
					}
				}
			}
		}
		System.out.print(cnt);
	}
	static boolean init() {
		graph = new ArrayList[N*N];
		valid = new boolean[N*N];
		for(int i = 0; i<N*N;i++) {
			graph[i] = new ArrayList<>();
		}
		boolean check = false;
		for(int i = 0;i<N;i++) {
			for(int j = 0; j<N;j++) {
				for(int k =0; k<4;k++) {
					int y = i+dy[k];
					int x = j+dx[k];
					if(x>=0&&x<N&&y>=0&&y<N) {
						if(Math.abs(arr[i][j]-arr[y][x])<=R&&L<=Math.abs(arr[i][j]-arr[y][x])) {
							graph[i*N+j].add(y*N+x);
							check = true;
						}
					}
				}
			}
		}
		return check;
	}
	static void bfs(int x) {
		Queue<Integer> qu = new LinkedList<>();
		seq = new LinkedList<>();
		valid[x]=true;
		qu.add(x);
		seq.add(x);
		while(!qu.isEmpty()) {
			int y = qu.poll();
			for(int i = 0; i<graph[y].size();i++) {
				int z = graph[y].get(i);
				if(!valid[z]) {
					valid[z] = true;
					qu.add(z);
					seq.add(z);
				}
			}
		}
	}
}