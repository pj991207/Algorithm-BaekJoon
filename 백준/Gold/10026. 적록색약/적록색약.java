import java.util.*;
import java.io.*;
public class Main {
	static int[][] map;
	static int[][] board;
	static int N;
	static int boardNum;
	static int mapNum;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];//적록색약
		board = new int[N][N];//정상인
		for(int i = 0; i<N;i++) {
			String line = bf.readLine();
			for(int j = 0; j<N;j++) {
				if(line.charAt(j)=='B') {
					map[i][j] = 1;
					board[i][j] = 1;
					continue;
				}
				if(line.charAt(j)=='R') {
					map[i][j] = 2;
					board[i][j] = 2;
					continue;
				}
				if(line.charAt(j)=='G') {
					map[i][j] = 2;
					board[i][j] = 3;
					continue;
				}
			}
		}
		boardNum = 0;
		mapNum = 0;
		for(int i =0 ; i<N;i++) {
			for(int j = 0 ; j<N;j++) {
				if(map[i][j]==1||map[i][j]==2) {
					bfs(new Node(i,j,map[i][j]),map);
					mapNum++;
				}
				if(board[i][j]==1||board[i][j]==2||board[i][j]==3) {
					bfs(new Node(i,j,board[i][j]),board);
					boardNum++;
				}
			}
		}
		System.out.println(boardNum+" "+mapNum);
	}
	static class Node{
		int y;
		int x;
		int color;
		public Node(int y, int x, int color) {
			this.y = y;
			this.x = x;
			this.color = color;
		}
	}
	static void bfs(Node node,int[][] arr){
		Queue<Node> q = new ArrayDeque<>();
		arr[node.y][node.x]=0;
		q.add(node);
		while(!q.isEmpty()) {
			Node n = q.poll();
			for(int i = 0; i<4;i++) {
				int ny = n.y+dy[i];
				int nx = n.x+dx[i];
				if(ny>N-1||ny<0||nx>N-1||nx<0) continue;
				if(arr[ny][nx]!=node.color) continue;
				arr[ny][nx] = 0;
				q.add(new Node(ny,nx,node.color));
			}
		}
	}
}