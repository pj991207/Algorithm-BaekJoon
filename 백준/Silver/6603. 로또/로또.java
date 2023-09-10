import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int[] nums;
	static int[] answer;
	static int R = 6;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N==0) {
				return;
			}
			nums = new int[N];
			for(int i= 0; i<N;i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			answer = new int[R];
			Combi(0,0);
			System.out.println("");
		}
	}	
	static void Combi(int cnt,int start) {
		if(cnt==R) {
			for(int e: answer) {
				System.out.print(e+" ");
			}
			System.out.println("");
			return;
		}
		for(int i = start;i<N;i++) {
			answer[cnt] = nums[i];
			Combi(cnt+1,i+1);
		}
	}
}