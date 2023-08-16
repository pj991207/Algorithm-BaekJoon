import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int ans = 0;
	static int[] map;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N];
		Nqueen(0);
		System.out.println(ans);
	}
	
	static void Nqueen(int x) {
//		if(!isAvaliable(x-1)) {
//			return;
//		}
		if(x==N) {
			ans++;
			return;
		}
		for(int i = 0; i<N;i++) {
			map[x] = i;
			if(!isAvaliable(x)) {
				continue;
			}
			Nqueen(x+1);
		}
	}
	
	static boolean isAvaliable(int x) {
		for(int i = 0; i<x;i++) {
			if(map[i]==map[x]||Math.abs(map[i]-map[x])==x-i) {
				return false;
			}
		}
		return true;
	}
}