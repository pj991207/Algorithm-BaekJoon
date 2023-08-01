import java.util.*;

import javax.sound.midi.Soundbank;

import java.io.*;
public class Solution {
	static int T;
	static int N = 9;
	static int R = 9;
	static boolean[] visited = new boolean[9];
	static int[] nums = new int[9];
	static int[] p = {0,1,2,3,4,5,6,7,8};
	static int[] arr;
	static int[] brr;
	static int win=0;
	static int lose=0;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<T;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arr = new int[9];
			brr = new int[9];
			win = 0;
			lose = 0;
			for(int j=0;j<9;j++) {
				arr[j]=Integer.parseInt(st.nextToken());
			}
			int[] crr = Arrays.copyOf(arr, arr.length);
			Arrays.sort(crr);
			int index = 0;
			for(int j = 1; j<19; j++) {
				if(Arrays.binarySearch(crr, j)<0) {
					brr[index++]=j;
				}
			}
			Perm(0);
			sb.append("#").append(i+1).append(" ");
			sb.append(win).append(" ").append(lose);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void Perm(int x){
		if(x==R) {
			int suma = 0;
			int sumb = 0;
			for(int i = 0; i<9;i++) {
				int a = arr[i];
				int b = brr[nums[i]];
				if(a-b>0) {
					suma += a+b;
				}else {
					sumb += a+b;
				}
			}
			if(suma>sumb) {
				win++;
			}else {
				lose++;
			}
			return;
		}
		for(int i = 0; i<N;i++) {
			if(visited[i])continue;
			visited[i] = true;
			nums[x] = p[i];
			Perm(x+1);
			visited[i]=false;
		}
	}
}