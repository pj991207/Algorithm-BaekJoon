import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] S;
	static int[] B;
	static boolean[] power;
	static int MIN = 1000000000;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// 값 초기화
		N = Integer.parseInt(bf.readLine());
		S = new int[N];
		B = new int[N];
		power = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		//부분집합 탐색을 통한 최솟값찾기
		PowerSet(0,0);
		System.out.println(MIN);
	}
	static void PowerSet(int x,int cnt) {
		if(x==N) {
			//부분집합을 통해서 최소합을 구한다
			if(cnt==0) {
				return;
			}
			int muxA = 1;
			int sumB = 0;
			for(int i = 0; i<N;i++) {
				if(power[i]) {
					muxA = muxA * S[i];
					sumB = sumB + B[i];
				}
			}
			MIN = Math.min(MIN, Math.abs(muxA-sumB));
			return;
		}
		power[x]=true;
		PowerSet(x+1,cnt+1);
		power[x]=false;
		PowerSet(x+1,cnt);
	}
}