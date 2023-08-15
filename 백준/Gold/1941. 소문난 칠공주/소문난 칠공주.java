import java.util.*;
import java.io.*;

public class Main {
	static int ans=0;
	static String[][] arr = new String[5][5];
	static boolean[][] map;
	static boolean[][] visited;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static int[] nums = new int[7];
	static int[] p = new int[25];
	static int N = 5;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Arrays.setAll(p,i->i);
		for(int i = 0; i<5;i++) {
			String[] st = bf.readLine().split("");
			for(int j = 0; j<5;j++) {
				arr[i][j]= st[j];
			}
		}
		Combi(0,0);
		System.out.println(ans);
	}
	static void Combi(int r,int start) {
		if(r==7) {
			int Y =0;
			int S =0;
			int by = nums[0]/5;
			int bx = nums[0]%5;
			boolean flag = true;
			
			map = new boolean[5][5];
			for(int i = 0; i<7;i++) {
				int y = nums[i]/5;
				int x = nums[i]%5;
				if(arr[y][x].equals("Y")) {
					Y++;
				}
				if(arr[y][x].equals("S")) {
					S++;
				}
				map[y][x] = true;
				if(Y>=4) {
					flag = false;
					break;
				}
			}
			//bfs를 통해서 연결여부를 확인
			visited = new boolean[5][5];
			if(nums.length!=bfs(nums[0])) {
				return;
			}
			
			if(flag&&S>=4) {
				//System.out.println(Arrays.toString(nums));
				ans++;
			}
			return;
		}
		for(int i = start;i<25;i++) {
			nums[r] = p[i];
			Combi(r+1,i+1);
		}
	}
	static int bfs(int num) {
		int cnt = 0;
		Queue<Point> q = new ArrayDeque<>();
		int y = num/5;
		int x = num%5;
		visited[y][x] = true;
		q.add(new Point(y,x));
		cnt++;
		while(!q.isEmpty()) {
			Point point = q.remove();
			int py = point.y;
			int px = point.x;
			for(int i =0 ; i<4;i++) {
				int my = py + dy[i];
				int mx = px + dx[i];
				if(my>=0&&my<N&&mx>=0&&mx<N) {
					if(visited[my][mx])continue;
					if(map[my][mx]) {
						q.add(new Point(my,mx));
						cnt++;
						visited[my][mx]=true;
					}
				}
			}
		}
		return cnt;
		
	}
	static class Point {
		int y;
		int x;
		public Point(int y,int x) {
			this.y = y;
			this.x = x;
		}
	}
}