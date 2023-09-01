import java.util.*;
import java.io.*;

public class Main {
	static int CH;
	static int N;
	static int R;
	static int[] p;
	static int cnt;
	static boolean[] visited;
	static int MIN;
	static Set<Integer> set;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		CH = Integer.parseInt(bf.readLine());
		MIN = Math.abs(CH-100);
		int K = Integer.parseInt(bf.readLine());
		
		N = 10-K;
		int size = 1;
		if(CH!=0) {
			size = (int)Math.log10(CH)+1; // log 를 사용할때 0이 오는 경우를 조심
		}
		
//		if(K==0) {
//			System.out.println(size);
//			return;
//		}
		if(N==0) {
			System.out.println(MIN);
			return;
		}
		
		p = new int[N];
		set = new HashSet<>();
		if(K!=0) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int i = 0; i<K;i++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
		}
		

		int index = 0;
		for(int i = 0; i<10;i++) {
			if(set.contains(i)) continue;
			p[index++] = i;
		}
		
		R = size;
		visited = new boolean[N];
		Perm(0,"");
		
		R = size+1;
		visited = new boolean[N];
		Perm(0,"");
		
		if(size>1) {
			R = size-1;
			visited = new boolean[N];
			Perm(0,"");
		}
		
		System.out.println(MIN);
	}
	static void Perm(int cnt,String str) {
		if(cnt==R) {
			int temp = str.length()+Math.abs(CH-Integer.parseInt(str));
			MIN = Math.min(temp,MIN);
			return;
		}
		if(str.length()>1&&str.charAt(0)=='0') {
			return;
		}
		for(int i = 0; i<N;i++) {
			Perm(cnt+1,str+String.valueOf(p[i]));
		}
	}
}