import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int K;
	static int answer;
	static boolean[][] table;
	public static void main(String[] args)throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		table = new boolean[N][N];
		for(int i = 0; i<N;i++) {
			int num = Integer.parseInt(bf.readLine());
			table[i][num] = true;
		}
		System.out.println(search(0));
	}
	static int search(int x) {
		answer = 0;
		int num = x;
		for(int j= 0;j<N;j++) {
			for(int i = 0; i<N;i++) {
				if(table[num][i]) {
					num = i;
					answer++;
					break;
				}
			}
			if(num==K) {
				return answer;
			}
		}
		return -1;
	}
}
