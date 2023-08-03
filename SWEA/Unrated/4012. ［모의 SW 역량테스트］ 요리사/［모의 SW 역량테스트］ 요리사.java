import java.util.*;
import java.io.*;

public class Solution {
	static int T;
	static int N;
	static int R;
	static int MIN = 100001;
	static int[] p;
	static int[] nums;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for (int h = 0; h < T; h++) {
			MIN = 100001;
			sb.append("#").append(h + 1).append(" ");
			N = Integer.parseInt(bf.readLine());
			p = new int[N];
			arr = new int[N][N];
			nums = new int[N / 2];
			R = N/2;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Arrays.setAll(p, m -> m + 1);
			Combi(0,0);
			sb.append(MIN+"\n");
		}
		System.out.println(sb);
	}

	static void Combi(int x,int start) {
		if(x==R) {
			int A = 0;
			for(int i = 0; i<nums.length-1;i++) {
				for(int j = i;j<nums.length;j++) {
					A += arr[nums[i]-1][nums[j]-1]+arr[nums[j]-1][nums[i]-1];
				}
			}
			int B = 0;
			int[] temp = new int[N/2];
			Arrays.sort(nums);
			int index = 0;
			for(int i = 1; i<N+1;i++) {
				if(Arrays.binarySearch(nums,i)<0) temp[index++]=i;
			}
			for(int i = 0;i<temp.length-1;i++) {
				for(int j=i;j<temp.length;j++) {
					B += arr[temp[i]-1][temp[j]-1]+arr[temp[j]-1][temp[i]-1];
				}
			}
			if(MIN>Math.abs(A-B)) {
				MIN = Math.abs(A-B);
			}
			return;
		}
		for(int i = start; i<N;i++) {
			nums[x]=p[i];
			Combi(x+1,i+1);
		}
	}
}
