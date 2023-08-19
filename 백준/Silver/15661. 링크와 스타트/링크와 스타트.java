import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static boolean[] check;
	static int[][] map;
	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		check = new boolean[N];
		map = new int[N][N];
		for(int i = 0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j = 0;j<N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		PowerSet(0,0);
		System.out.println(MIN);
	}
	static void PowerSet(int cnt,int num) {
		if(cnt==N) {
			if(num==0||num==1) {
				return;
			}
			if(num>N/2) {
				return;
			}
			
			int[] start = new int[num];
			int[] link = new int[N-num];
			int idx = 0;
			int idx2 = 0;
			int startSum = 0;
			int linkSum = 0;
			
			for(int i = 0;i<N;i++) {
				if(check[i]) {
					start[idx++]=i;
				}
				if(!check[i]) {
					link[idx2++]=i;
				}
			}
			//System.out.println(Arrays.toString(check)+" "+Arrays.toString(start)+" "+Arrays.toString(link));
			for(int i = 0;i<start.length;i++) {
				for(int j = 0;j<start.length;j++) {
					if(i==j) {
						continue;
					}
					startSum += map[start[i]][start[j]];
				}
			}
			
			for(int i = 0;i<link.length;i++) {
				for(int j = 0;j<link.length;j++) {
					if(i==j) {
						continue;
					}
					linkSum += map[link[i]][link[j]];
				}
			}
			
			MIN = Math.min(MIN,Math.abs(startSum-linkSum));
//			System.out.println("");
			return;
		}
		check[cnt] = true;
		PowerSet(cnt+1,num+1);
		check[cnt]  = false;
		PowerSet(cnt+1,num);
	}
}