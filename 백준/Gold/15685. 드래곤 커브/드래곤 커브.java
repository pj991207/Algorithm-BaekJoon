import java.util.*;
import java.io.*;
//1. 드래곤 커브를 만들어야함
//2. 정사각형 판정
public class Main {
	static int N;
	static int y;
	static int x;
	static int d;
	static int g;
	static int cnt;
	static int[] dy = {0,-1,0,1};
	static int[] dx = {1,0,-1,0};
	static ArrayDeque<Integer> q;
	static boolean[][] map = new boolean[200][200];
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		for(int i = 0; i<N;i++) {
			q = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(bf.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			q.add(d);
			map[y][x] = true;
			curve();
			while(!q.isEmpty()) {
				int move = q.remove();
				y += dy[move];
				x += dx[move];
				map[y][x] = true;
			}
		}
		check();
		System.out.println(cnt);
	}
	static void curve() {
		for(int i = 1;i < g+1;i++) {
			ArrayDeque<Integer> temp = new ArrayDeque<>(q);
			while(!temp.isEmpty()) {
				int convert = temp.removeLast();
				q.add((convert+1)%4);
			}
		}
	}
	static void check() {
		for(int i = 0;i<101;i++) {
			for(int j = 0; j<101;j++) {
				int y = i;
				int x = j;
				if(x+1>101||y+1>101) {
					continue;
				}
				if(map[y][x]&&map[y+1][x]&&map[y][x+1]&&map[y+1][x+1]) {
					cnt++;
				}
			}
		}
	}

}