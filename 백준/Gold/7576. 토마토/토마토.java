import java.util.*;
import java.io.*;
public class Main {
	static int[][] box;
	static int M;
	static int N;
	static int[][] value;
	//static boolean[][] check;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		value = new int[N][M];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<M;j++) {
				box[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				if(box[i][j]==0) {
					value[i][j] = -1;
				} else {
					value[i][j] = -2;
				}
			}
		}
		Queue<Pair> x = new LinkedList<>();
		boolean flag = false;
		for(int i = 0;i<N;i++) {
			for(int j = 0; j<M;j++) {
				if(box[i][j]==1) {
					Pair pair = new Pair(i,j);
					x.add(pair);
				}
				if(box[i][j]==0)
					flag = true;
					continue;
				}
		}
		int answer = 0;
		if(!flag) {
			System.out.println(answer);
		}
		else {
			answer=bfs(x);
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<M;j++) {
					if(value[i][j]==-1) {
						answer = -1;
						System.out.print(answer);
						return;
					}
				}
			}
			System.out.print(answer);
		}
	}
	static int bfs(Queue<Pair> p) {
		Queue<Pair> q = new LinkedList<>();
		int len = p.size();
		int answer = 0;
		for(int i = 0; i<len;i++) {
			Pair pair = p.poll();
			value[pair.y][pair.x]=0;
			q.add(pair);
		}
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			int x = pair.x;
			int y = pair.y;
			for(int i=0;i<4;i++) {
				int c= y + dy[i];
				int r = x + dx[i];
				if(c>=0&&c<N&&r>=0&&r<M) {
					if(value[c][r]==-1)
					{
						value[c][r] = value[y][x]+1;
						if(answer<value[c][r]) {
							answer = value[c][r];
						}
						q.add(new Pair(c,r));
					}
				}
			}
		}
		return answer;
	}
}
class Pair{
	int x;
	int y;
	Pair(int y,int x){
		this.x = x;
		this.y = y;
	}
}
