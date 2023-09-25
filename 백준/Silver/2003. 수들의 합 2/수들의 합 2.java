import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int M;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int sum = 0;
		int answer = 0;
		while(true) {
			if(sum>=M) {
				sum -= arr[start++];
			}
			else if(end==N) {
				break;
			}
			else {
				sum += arr[end++];
			}
			if(sum==M) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}