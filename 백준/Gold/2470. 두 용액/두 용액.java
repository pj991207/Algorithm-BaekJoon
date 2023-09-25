import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		arr = new int[N];
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] answer = new int[2];
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length-1;
		int sum =arr[start]+arr[end];
		answer[0] = arr[start];
		answer[1] = arr[end];
		while(true) {
			int value = arr[start]+arr[end];
			if(Math.abs(sum)>Math.abs(value)) {
				sum = arr[start]+arr[end];
				answer[0] = arr[start];
				answer[1] = arr[end];
			}
			if(value==0) {
				break;
			}
			if(value<0) {
				start++;
			}
			if(value>0) {
				end--;
			}
			if(start>=end) {
				break;
			}
		}
		System.out.println(answer[0]+" "+answer[1]);
	}
}