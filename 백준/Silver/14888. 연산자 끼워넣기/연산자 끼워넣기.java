import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] arr;
	static int[] calc;
	static long MAX = -10000000000L;
	static long MIN = 10000000000L;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		arr = new int[N];
		calc = new int[4];
		
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st=new StringTokenizer(bf.readLine());
		for(int i = 0; i<4;i++) {
			calc[i] = Integer.parseInt(st.nextToken());
		}
		bfs(0,arr[0]);
		System.out.println(MAX);
		System.out.println(MIN);
	}
	static void bfs(int x, int sum) {
		if(x==N-1) {
			MAX = Math.max(MAX,sum);
			MIN = Math.min(MIN,sum);
			return;
		}
		if(calc[0]!=0) {
			calc[0]--;
			bfs(x+1,sum+arr[x+1]);
			calc[0]++;
		}
		if(calc[1]!=0) {
			calc[1]--;
			bfs(x+1,sum-arr[x+1]);
			calc[1]++;
		}
		if(calc[2]!=0) {
			calc[2]--;
			bfs(x+1,sum*arr[x+1]);
			calc[2]++;
		}
		if(calc[3]!=0) {
			calc[3]--;
			if(arr[x]==0) {
				bfs(x+1,0);
				calc[3]++;
			}
			bfs(x+1,sum/arr[x+1]);
			calc[3]++;
		}
	}
}