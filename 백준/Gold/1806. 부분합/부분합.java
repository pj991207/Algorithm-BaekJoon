import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int[] arr = new int[N];
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		long sum = 0;
		int answer = 1000000;
		while(true) {
			if(sum>=M) {
				sum -= arr[start++];
			}else if(end==N) {
				break;
			}
			else {
				sum += arr[end++];
			}
			if(sum>=M) {
				answer = Math.min(answer,Math.abs(start-end));
			}
		}
		if(answer==1000000) {
			answer = 0;
		}
		System.out.println(answer);
	}
}