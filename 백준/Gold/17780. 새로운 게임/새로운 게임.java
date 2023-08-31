import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int K;
	static int[][] board;
	static int[][] map;
	static int cnt;
	static int[] dy = { 100, 0, 0, -1, 1 };
	static int[] dx = { 100, 1, -1, 0, 0 };
	static ArrayDeque<Node>[] deq;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		board = new int[N][N];
		deq = new ArrayDeque[K + 1];

		for (int i = 0; i < K + 1; i++) {
			deq[i] = new ArrayDeque<Node>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			deq[i + 1].add(new Node(y, x, d, i + 1));
			map[y][x] = i + 1;
		}
		end:
		while (true) {
			move();
			cnt++;
			for (ArrayDeque e : deq) {
				if (e.size() >= 4) {
					break end;
				}
			}
			if (cnt > 1000) {
				break;
			}
		}
		if (cnt > 1000) {
			System.out.print(-1);
			return;
		}
		System.out.print(cnt);
	}

	static void move() {
		for (int i = 1; i < K + 1; i++) {
			if (deq[i].size()==0)continue;
			Node node = deq[i].peekFirst();
			int ny = node.y + dy[node.d];
			int nx = node.x + dx[node.d];
			// 파란색이라면
			if ((ny >= N  || nx >= N || ny < 0 || nx < 0) || board[ny][nx] == 2) {
				Node blueNode = deq[i].removeFirst();
				if (node.d == 1) {
					deq[i].addFirst(new Node(blueNode.y, blueNode.x, 2, blueNode.index));
				}
				if (node.d == 2) {
					deq[i].addFirst(new Node(blueNode.y, blueNode.x, 1, blueNode.index));
				}
				if (node.d == 3) {
					deq[i].addFirst(new Node(blueNode.y, blueNode.x, 4, blueNode.index));
				}
				if (node.d == 4) {
					deq[i].addFirst(new Node(blueNode.y, blueNode.x, 3, blueNode.index));
				}
				node = deq[i].peekFirst();
				ny = node.y + dy[node.d];
				nx = node.x + dx[node.d];
			}
			if ((ny >= N || nx >= N || ny < 0 || nx < 0) || board[ny][nx] == 2) {
				continue;
			}
			// 빨간색이라면
			if (board[ny][nx] == 1) {
				map[node.y][node.x] = 0;
				red(ny, nx, i);
				continue;
			}
			// 하얀색이라면
			if (board[ny][nx] == 0) {
				map[node.y][node.x] = 0; // 움직임 이전거 지우기
				white(ny, nx, i); // 바닥이 white인 경우
				continue;
			}
		}
	}

	static void red(int y, int x, int index) {
		if(deq[index].size()==1){
			white(y,x,index);
			return;
		}
		if (map[y][x] == 0) { // 만약 타일이 없는 경우
			Node lastNode = deq[index].peekLast();
			int nextIndex = lastNode.index;
			while (!deq[index].isEmpty()) {
				Node node = deq[index].removeLast();
				deq[nextIndex].addLast(new Node(y, x, node.d, node.index));
			}
			map[y][x] = nextIndex;
			return;
		}
		if (map[y][x] != 0) { // 만약 타일이 있는 경우
			while (!deq[index].isEmpty()) {
				Node node = deq[index].removeLast();
				deq[map[y][x]].addLast(new Node(y, x, node.d, node.index));
			}
			return;
		}
	}

	static void white(int y, int x, int index) {
		if (map[y][x] == 0) { // 만약 말이 없는 경우
			map[y][x] = index;
			int len = deq[index].size();
			for (int i = 0; i < len; i++) {
				Node node = deq[index].removeFirst();
				deq[index].addLast(new Node(y, x, node.d, node.index));
			}
			return;
		}
		if (map[y][x] != 0) { // 만약 말이 있는 경우
			while (!deq[index].isEmpty()) {
				Node node = deq[index].removeFirst();
				deq[map[y][x]].addLast(new Node(y, x, node.d, node.index));
			}
			return;
		}
	}

	static class Node {
		int y;
		int x;
		int d;
		int index;

		Node(int y, int x, int d, int index) {
			this.y = y;
			this.x = x;
			this.d = d;
			this.index = index;
		}
	}
}