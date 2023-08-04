import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] sum;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		sum = new int[N+1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1]+arr[i];
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int ans = 0;
			int first = Integer.parseInt(st.nextToken())-1;
			int last = Integer.parseInt(st.nextToken());
			ans = sum[last]-sum[first];
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}
}
