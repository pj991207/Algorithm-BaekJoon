import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int K;
	static int[] arr;
	static int len;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[1000000];
		len = arr.length;
		Arrays.fill(arr, -1);
		bfs(N);
		System.out.println(arr[K]);
	}

	static void bfs(int x) {
		Queue<Integer> qu = new LinkedList<>();
		Queue<Integer> next_qu = new LinkedList<>();
		arr[x] = 0;
		qu.add(x);
		while (!qu.isEmpty()) {
			int y = qu.poll();
			if (2 * y >= 0 && 2 * y < len) {
				if (arr[2 * y] == -1) {
					arr[2 * y] = arr[y];
					qu.add(2 * y);
				}
			}
			if (y - 1 >= 0 && y - 1 < len) {
				if (arr[y - 1] == -1) {
					arr[y - 1] = arr[y] + 1;
					next_qu.add(y - 1);

				}
			}
			if (y + 1 >= 0 && y + 1 < len) {
				if (arr[y + 1] == -1) {
					arr[y + 1] = arr[y] + 1;
					next_qu.add(y + 1);
				}
			}
			if (qu.isEmpty()) {
				qu = next_qu;
				next_qu = new LinkedList<>();
			}
		}
	}
}