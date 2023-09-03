import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] list;
	static int[][] map;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static int ans =0;
	static Queue<Node> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		list = new int[N*N][5];
		map = new int[N][N];
		for(int i = 0; i<N*N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<5;j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i<N*N;i++) {
			findOne(i);
			if(q.size()==1) {
				Node node = q.poll();
				map[node.y][node.x]=list[i][0];
				continue;
			}//q의 크기가 1 초과이면 여러개의 점이 있다고 생각함.
			findTwo();
			if(q.size()==1) {
				Node node = q.poll();
				map[node.y][node.x]=list[i][0];
				continue;
			}
			findThree();
			if(q.size()==1) {
				Node node = q.poll();
				map[node.y][node.x]=list[i][0];
				continue;
			}
			findFour();
			Node node = q.poll();
			map[node.y][node.x] = list[i][0];
		}
		score();
		System.out.println(ans);
	}
	static void score() {
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<N;j++) {
				int num = map[i][j];
				int cnt = 0;
				Set<Integer> set = new HashSet<>();
				for(int k = 0;k<N*N;k++) {
					if(num==list[k][0]) {
						num = k;
						break;
					}
				}
				for(int k = 1;k<5;k++) {
					set.add(list[num][k]);
				}
				for(int k = 0; k<4;k++) {
					int ny = i+dy[k];
					int nx = j+dx[k];
					if(ny>N-1||ny<0||nx>N-1||nx<0)continue;
					if(set.contains(map[ny][nx]))cnt++;
				}
				ans += (int)Math.pow(10,cnt-1);
			}
		}
	}
	//첫번째 방법을 통해서 위치를 구하기
	static void findOne(int e) {
		int[][] valid = new int[N][N];
		for(int[] i : valid) {
			Arrays.fill(i,-1);//최대가 0인경우도 존재하기떄문에
		}
		int max = 0;
		Set<Integer> set = new HashSet<>();
		for(int i = 1; i<5;i++) {
			set.add(list[e][i]);
		}
		for(int i = 0;i <N;i++) {
			for(int j = 0;j<N;j++) {
				int cnt = 0;
				if(map[i][j]!=0)continue;//비어있는 칸이 아님으로 예외
				for(int k = 0; k<4;k++) {
					int ny = i+dy[k];
					int nx = j+dx[k];
					if(ny>N-1||ny<0||nx>N-1||nx<0)continue;
					if(set.contains(map[ny][nx])) cnt++;
				}
				valid[i][j]=cnt;//각위치에서 해당하는 좋아하는 학생의 수를 기록
				max = Math.max(max,cnt);
			}
		}
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<N;j++) {
				if(valid[i][j]==max) {
					q.add(new Node(i,j));
				}
			}
		}
	}
	//두번째 방법을 통해서 위치 찾기
	static void findTwo() {
		int len = q.size();
		int[][] valid = new int[N][N];
		for(int[] i : valid) {
			Arrays.fill(i,-1);//최대가 0인경우도 존재하기떄문에
		}
		int max = 0;
		for(int i = 0; i<len;i++) {
			Node node = q.poll();
			int cnt = 0;
			for(int k = 0; k<4;k++) {
				int ny = node.y+dy[k];
				int nx = node.x+dx[k];
				if(ny>N-1||ny<0||nx>N-1||nx<0)continue;
				if(map[ny][nx]==0)cnt++;
			}
			valid[node.y][node.x]=cnt;
			max = Math.max(max,cnt);
		}
		for(int i = 0;i<N;i++) {
			for(int j = 0; j<N;j++) {
				if(valid[i][j]==max) {
					q.add(new Node(i,j));
				}
			}
		}
	}
	//세번째 방법을 통해서 행의 번호가 가장 작은 칸 찾기
	static void findThree() {
		int len = q.size();
		int min= N;
		for(int i = 0; i<len;i++) {
			Node node = q.poll();
			min = Math.min(min,node.y);
			q.add(node);
		}
		for(int i = 0; i<len;i++) {
			Node node = q.poll();
			if(min==node.y) {
				q.add(node);
			}
		}
	}
	//네번쨰 방법을 통해서 열의 번호가 가장 작은 칸 찾기
	static void findFour() {
		int len = q.size();
		int min= N;
		for(int i = 0; i<len;i++) {
			Node node = q.poll();
			min = Math.min(min,node.x);
			q.add(node);
		}
		for(int i = 0; i<len;i++) {
			Node node = q.poll();
			if(min==node.x) {
				q.add(node);
			}
		}
	}
	static class Node{
		int y;
		int x;
		public Node(int y,int x) {
			this.y = y;
			this.x = x;
		}
	}
}