import java.util.*;
import java.io.*;
public class Main {
	static int T;
	static int N;
	static int[][] board;
	static int[] dy = {-2,-1,1,2,2,1,-1,-2};
	static int[] dx = {1,2,2,1,-1,-2,-2,-1};
	static int fx;
	static int fy;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<T;i++) {
			N = Integer.parseInt(bf.readLine());
			board = new int[N][N];
			for(int j = 0; j<N;j++) {
				Arrays.fill(board[j],-1);
			}
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			Node node = new Node(sy,sx);
			st = new StringTokenizer(bf.readLine());
			fy = Integer.parseInt(st.nextToken());
			fx = Integer.parseInt(st.nextToken());
			bfs(node);
			sb.append(board[fy][fx]).append("\n");
		}
		System.out.println(sb);
	}
	static void bfs(Node start) {
		Queue<Node> qu = new LinkedList<>();
		int y = start.y;
		int x = start.x;
		board[y][x] = 0;
		qu.add(start);
		while(!qu.isEmpty()) {
			Node node = qu.poll();
			y = node.y;
			x = node.x;
			for(int i = 0; i<dy.length;i++) {
				int nextY = y + dy[i];
				int nextX = x + dx[i];
				if(nextY>=0&&nextY<N&&nextX>=0&&nextX<N) {
					if(board[nextY][nextX]==-1||(board[nextY][nextX] > board[y][x]+1)) {
						board[nextY][nextX] = board[y][x]+1;
						qu.add(new Node(nextY,nextX));
					}
				}
			}
			
		}
	}
}
class Node{
	int y;
	int x;
	public Node(int y,int x) {
		this.y= y;
		this.x = x;
	}
}
